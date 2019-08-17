package StudyRoom;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {	// 주문하기 기능을 구현하는 클래스
	Scanner scan = new Scanner(System.in);
	ArrayList<Snack> snacklist = new ArrayList<>();	// 과자류 메뉴 목록을 저장
	ArrayList<Drink> drinklist = new ArrayList<>();	// 음료 메뉴 목록을 저장
	
	public Order() {	// 상품의 초기항목 설정을 위해 Order 생성자에서 reset 메소드를 실행
		resetSnack();
		resetDrink();
	}
	
	public void resetSnack() {	// 스낵의 초기값을 설정하는 메소드
		Snack si = new Snack("초콜렛", 2000, "당 떨어질때는 초콜렛!", ItemType.SNACK);
		snacklist.add(si);
		
		si = new Snack("껌", 1500, "잠이 깨는 껌~", ItemType.SNACK);
		snacklist.add(si);
		
		si = new Snack("사탕", 300, "달달한 사탕 >(//)<", ItemType.SNACK);
		snacklist.add(si);
	}
	
	public void resetDrink() {	// 음료의 초기값을 설정하는 메소드
		Drink di = new Drink("아메리카노", 2000, "리필가능", ItemType.DRINK);
		drinklist.add(di);
		
		di = new Drink("녹차", 500, "보성에서 직접 공수", ItemType.DRINK);
		drinklist.add(di);
		
		di = new Drink("미숫가루", 1200, "배고플땐 미숫가루~", ItemType.DRINK);
		drinklist.add(di);
	}
	
	public void order_listView() {		
		System.out.println("── 주문하기 ──────────────────────────────────────────");
		System.out.println("[1] 스낵");
		System.out.println("[2] 음료");
		System.out.println("[3] 시간추가");
		System.out.println("[b] 이전");
		System.out.println("───────────────────────────────────────────────────");
		
		System.out.print("선택 >> ");
		String in = scan.next();
		if(in.equals("b")) {
			Launcher.start();
		}
		int i = Integer.parseInt(in);
		
		switch(i) {

			case 1:
				snackMenu();
				break;
			case 2:
				drinkMenu();
				break;
			case 3:
				addTime();
				break;
		}
	}
	
	public void addTime() {		// 시간추가
		User tuser = new User();
		
		System.out.print("자리 번호를 입력하세요 >> ");
		int seatnum = scan.nextInt();
		int index = seatnum-1;
		System.out.print("추가하실 시간을 입력하세요(시간당 1,000원) >> ");
		int addnum = scan.nextInt();
		
		tuser = Launcher.s.userlist.get(index);
		tuser.setUseTime(addnum);
		Launcher.s.userlist.set(index, tuser);
		System.out.print("\n");
		System.out.println("***************************************************");
		System.out.println(seatnum + "번 자리에 " + addnum + "시간 추가가 완료되었습니다.");
		System.out.println("***************************************************");
		System.out.print("\n");
		Launcher.start();
	}
	
	public void snackMenu() {		// 과자메뉴
		int num;
		Snack tsnack = new Snack();	// snack의 세부항목을 가져오기 위한 임시 인스턴스
		User tuser = new User();			// User의 세부항목을 가져오기 위한 임시 인스턴스
		
		System.out.println("── SNACK ──────────────────────────────────────────");	// snacklist 항목을 표시
		for(int i=0; i<snacklist.size(); i++) {
			tsnack = snacklist.get(i);
			num = i+1;
			System.out.printf("[%d] %s \n", num, tsnack.name);
		}
		System.out.println("[b] 이전");
		System.out.println("───────────────────────────────────────────────────");
		System.out.print("선택 >> ");
		String in = scan.next();
		if(in.equals("b")) {
			order_listView();
		}
		int i = Integer.parseInt(in);
		tsnack = snacklist.get((i-1));
		tsnack.showItem();
		System.out.println("[s] 구매하기, [b] 이전 ");
		System.out.print("선택 >> ");
		String j = scan.next();
		switch(j) {
			case "s":
				System.out.print("자리 번호를 입력하세요 >> ");
				i = scan.nextInt();
				tuser = Launcher.s.userlist.get((i-1));
				tuser.setBuyItem(tsnack.price);
				System.out.print("\n");
				System.out.println("***************************************************");
				System.out.println(i+"번 자리에서 "+tsnack.name+" 구매가 완료되었습니다.");
				System.out.println("***************************************************");
				System.out.print("\n");
				Launcher.start();
				break;
			case "b":
				snackMenu();
				break;
		}
	}
	
	public void drinkMenu() {		// 음료메뉴
		int num;
		Drink tdrink = new Drink();	// drink의 세부항목을 가져오기 위한 임시 인스턴스
		User tuser = new User();			// User의 세부항목을 가져오기 위한 임시 인스턴스
		
		System.out.println("── DRINK ──────────────────────────────────────────");	// drink항목을 표시
		for(int i=0; i<drinklist.size(); i++) {
			tdrink = drinklist.get(i);
			num = i+1;
			System.out.printf("[%d] %s \n", num, tdrink.name);
		}
		System.out.println("[b] 이전");
		System.out.println("───────────────────────────────────────────────────");
		System.out.print("선택 >> ");
		String in = scan.next();
		if(in.equals("b")) {
			order_listView();
		}
		int i = Integer.parseInt(in);
		tdrink = drinklist.get((i-1));
		tdrink.showItem();
		System.out.println("[s] 구매하기, [b] 이전 ");
		System.out.print("선택 >> ");
		String j = scan.next();
		switch(j) {
			case "s":
				System.out.print("자리 번호를 입력하세요 >> ");
				i = scan.nextInt();
				tuser = Launcher.s.userlist.get((i-1));
				tuser.setBuyItem(tdrink.price);
				System.out.print("\n");
				System.out.println("***************************************************");
				System.out.println(i+"번 자리에서 "+tdrink.name+" 구매가 완료되었습니다.");
				System.out.println("***************************************************");
				System.out.print("\n");
				Launcher.start();
				break;
			case "b":
				drinkMenu();
				break;
		}
	}
}
