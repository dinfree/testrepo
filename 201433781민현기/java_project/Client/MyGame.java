package Client;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.*;

// pGame 인터페이스를 기반으로  MyGame 클래스 구현
public class MyGame implements pGame {
	// 회원 정보 배열
	User[] users = new User[4];
	
	// 아이템 정보 배열
	Product[] products = new Product[5];
	
	// 아이템 추가를 위한 장바구니
	ArrayList<Product> cart = new ArrayList<Product>();
		
	// 키보드 입력으로 문자열 입력받기 위한 Scanner 객체 생성
	Scanner scan = new Scanner(System.in);
	
	// 선택된 사용자 index 보관
	int selUser;

	//서버와의 연결을 위한 소켓 객체
	Socket sc;

	//서버로 로그 데이터 전송을 위한 스트림
	PrintWriter writer;

	//서버로 부터 공지를 읽기위한 스트림
	BufferedReader br;

	// 개임 이름
	String title;

	//선택한 사용자
	User player;

	//서버와 주고 받는 메시지
	private String msg=null;

	//임의의 난수 생성;
	Random rm= new Random();

	//현재 시간
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");

	private int total=0;
	private int i=0;
	private int totalHP =0;


	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 프로그램 메인 시작 메서드
	 */
	public void start() {
		//서버와 소켓 연결
		try {
			sc=new Socket("127.0.0.1",5005); //로컬 서버로 접속
			br=new BufferedReader(new InputStreamReader(sc.getInputStream())); //서버로 부터 데이터를 받기위한 스트림 생성

			System.out.println(("게임 실행"));
			System.out.println(("========================================="));
			if((msg=br.readLine())!=null){
				System.out.println("공지!!");
				System.out.println(msg);
			}



			System.out.println(title+" : 메인화면 - 계정 선택");
			System.out.println("========================");
			int i=1;

			// 등록된 사용자 정보 출력
			for(User u : users) {
				System.out.printf("[%d]%s(%s)\n",i,u.getName(),u.getUserType());
				i++;
			}

			System.out.println("[x]종 료");
			System.out.print("선택 : ");
			String sel = scan.next();
			System.out.println("## "+sel+"선택 ##");

			// 선택된 메뉴에 따라 처리
			switch(sel) {
				case "x":
					sc.close();
					System.out.println("게임을 종료합니다.");
					System.exit(0);
					break;
				default:
					selUser = Integer.parseInt(sel)-1;
					sendData(format1.format (System.currentTimeMillis())+" 사용자: "+users[selUser].getName()+" 로그인\r\n");
					showMenu();
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("서버 에러");
		}

	}


	public void startGame(){
		System.out.println("사냥을 시작합니다");
		sendData(format1.format (System.currentTimeMillis())+" 사용자: "+player.getName()+" 사냥 시작\r\n");
		int getMoney=rm.nextInt(401)+100; //100~500 사이의 골드 획드
		int getDamage=rm.nextInt(101);  //0~100 사이의 데미지 획득

		System.out.println(getMoney+"골드를 획득했습니다");
		player.setMoney(player.getMoney()+getMoney);
		System.out.println(getDamage+"만큼의 데미지를 받았습니다.\n\n");
		player.setHp(player.getHp()-getDamage);
		sendData(format1.format (System.currentTimeMillis())+" 사용자: "+player.getName()+" 획득 머니:"+getMoney +" 입은 데미지: "+getDamage+"\r\n");
		showMenu();
	}

	public void showMenu(){
		player=users[selUser];
		sendData(format1.format (System.currentTimeMillis())+" 사용자: "+player.getName()+" 현재 골드: "+player.getMoney()+" 현재 HP: "+player.getHp()+"\r\n");

		if(player.getHp()<=0){
			System.out.println("HP가 0이하로 떨어졌습니다. 게임을 종료합니다");

			sendData(format1.format (System.currentTimeMillis())+" 사용자 "+player.getName()+" 죽음\n");
			endGmae();
			System.exit(0);

		}
		System.out.println("\n\n"+player.getName()+"님 환영합니다");
		player.showStatus();
		System.out.println("        행동 선택         ");
		System.out.println("=========================");
		System.out.println("[1]: 사냥");
		System.out.println("[2]: 상점");
		System.out.println("[x]: 종료");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");

		switch (sel){
			case "1":
				startGame();
				break;
			case "2":
				productList();
				break;
			case "x":
				endGmae();
				System.out.println("게임을 종료합니다.");
				System.exit(0);
		}

	}

	//서버와의 연결 종료
	public void endGmae(){
		try {
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//서버로 데이터 전송
	public void sendData(String data){
		try {
			writer=new PrintWriter(new OutputStreamWriter(sc.getOutputStream()),true);
			writer.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}




	/**
	 * 물약 목록을 보고 구매하기 위한 메서드
	 */
	public void productList() {


		System.out.println("상점");
		System.out.println("=========================");
		int i=1;
		
		// 등록된 상품 정보 출력
		for(Product p : products) {
			System.out.print("["+i+"]");
			p.printDetail();
			i++;
		}

		System.out.println("==========장바구니=============");
		if(cart.size()==0){
			System.out.println("      비어있음");
		}else {
			showCart();
		}

		System.out.println("==============================");
		System.out.println("[h]메인화면");
		System.out.println("[c]결제");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "h":
				cart.clear();
				total=0;
				totalHP =0;
				cart.clear();
				showMenu();
				break;
			case "c":
				checkOut();
				break;
			default:
				int psel = Integer.parseInt(sel)-1;
				cart.add(products[psel]);
				productList();
		}
	}

	public void showCart(){

		int i=1;
		int random=rm.nextInt(51)+50;  // 50~100 사이의 난수 생성
		int lucky=rm.nextInt(2); //0: 회복 1: 악화
		// 장바구니에 등록된 상품 정보 출력
		if(total!=0 && totalHP!=0){
			total=0;
			totalHP=0;
		}
		for(Product p : cart) {
			System.out.printf("[%d]%s(%s)\n",i,p.pname,p.price);


			if(p.pname=="알수 없는 물약"){
				if(lucky==0){
					p.point=random;
				}else{
					p.point=random*(-1);
				}
			}
			total = total + p.price;
			totalHP = totalHP +p.point;
			i++;
		}
	}

	/**
	 * 결제 진행을 위한 체크아웃 처리 메서드
	 */
	public void checkOut() {
		System.out.println("\n장바구니");
		System.out.println("=========================");

		for(Product p : cart) {
			System.out.printf("[%d]%s(%s)\n",++i,p.pname,p.price);


			}




		System.out.println("=========================");


		// 합계 출력
		System.out.println("합계: "+total+" 골드 입니다.");
		System.out.println("[p]이전 , [q]결제");
		System.out.print("선택 : ");
		String sel = scan.next();

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "q":
					if(player.getMoney()<total){
						System.out.println("금액이 부족합니다");
						checkOut();
						break;
					}else{
						player.setMoney((total*-1)+player.getMoney()); //사용자 금액 변경
						player.setHp(totalHP +player.getHp()); // 사용자의 상태 변경
						for(Product p:cart){
							sendData(format1.format (System.currentTimeMillis())+" 사용자: "+player.getName()+" "+p.pname +" 구매\r\n");
							p.printExtra();
						}
						System.out.println("## 결제가 완료 되었습니다. ##");
						//카트 초기화 작업
						cart.clear();
						total=0;
						totalHP =0;
					}

					showMenu();
					break;
			case "p":productList();break;
			default: checkOut();
		}		
	}
	
	/**
	 *  프로그램에서 사용하기 위한 예제 사용자 등록 메서드
	 */
	public void genUser() {
		User user = new User("홍길동",2100,UserType.HEALER);
		users[0] = user;
		user = new User("블로거",1000,UserType.TANKER);
		users[1] = user;
		user = new User("강호동",100,UserType.DEALER);
		users[2] = user;
		user = new User("유재석",5000,UserType.DEALER);
		users[3] = user;
	}
	
	/**
	 *  프로그램에서 사용하기 위한 예제 상품 등록 메서드
	 */
	public void genProduct() {
		Portion cp = new Portion("빨간 물약",500,+30);
		products[0] = cp;
		cp = new Portion("노란 물약",700,+50);
		products[1] = cp;
		Poison st =new Poison("뱀술",400,-50);
		products[2] = st;
		st =new Poison("마녀의 약",500,-30);
		products[3] = st;
		RandomDrink st2 = new RandomDrink(100);
		products[4] = st2;
	}
}