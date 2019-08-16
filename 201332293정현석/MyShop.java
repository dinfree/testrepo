package javabasic.week2project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MyShop implements IShop {

	Burger [] burgers=new Burger[4];
	SideMenu [] sides=new SideMenu[4];
	DrinkMenu[] drinks=new DrinkMenu[3];//버거, 음료, 사이드를 미리 선언하기 위한 배열
	
	ArrayList <Order> orderlist =new ArrayList<Order>();//주문 내역을 저장하기 위한 ArrayList
	
	Scanner scan=new Scanner(System.in);
	
	String UserSel;
	int Bsel, Ssel, Dsel;
	//사용자, 버거, 사이드, 음료에 대한 변수
	int addCost;
	int selSet;//세트 선택 여부에 대한 변수
	String title="BurgerShop";
	File file = new File("C:/Temp/MyShop.txt");//파일 객체 생성
     
	
	public void start() {
		
		System.out.println(title+"주문");
		System.out.println("========================");
		System.out.println("[1] 매장에서 식사");
		System.out.println("[2] 테이크 아웃");
		System.out.println("[x] 종 료");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		switch (sel) {
		case "x": System.exit(0);break;
		case "m" : {
			System.out.println("관리자 모드에 들어갑니다.");
			ManagerMode();
			start();
			break;
			}//관리자 모드에 관한 선택. 손님에게는 보이지 않도록 설정한다.
		default :
			if(Integer.parseInt(sel)==1)
			UserSel = "매장";
			else 
			UserSel = "테이크 아웃";
			BurgerList();
			break;
		}
		
		}//start() 종료
	public void ManagerMode() {
		System.out.println(title + "현재까지의 주문 내역 ");
		System.out.println("==============================");
		try {
			 
           
            FileReader filereader = new FileReader(file); //입력 스트림 생성
            int ch = 0;
            while((ch = filereader.read()) != -1){
                System.out.print((char)ch);
            }
            filereader.close();
            System.out.println("==============================");
            start();//
            
		} catch (IOException e) {
			e.printStackTrace();//에러 상황이 담긴 상황을 자세하게 표시해 준다.(기본코드)
		} 
	}//관리자 모드 종료
	
	public void BurgerList () {
		System.out.println(title+" : 상품 목록 - 상품 선택");
		System.out.println("=========================");
		int i=1;
		
		for (Menu b: burgers) {
			System.out.print("["+i+"]");
			b.printMenu();
			i++;
		}//메뉴 리스트 출력한다.
		
		
		System.out.println("[h]이전화면");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		switch(sel) {
		case "h":start();break;
		default:
			Bsel = Integer.parseInt(sel);
			ChooseSet();
	}
	}//BurgerList() 종료
	public void ChooseSet() {
		System.out.println("세트로 하시겠습니까?");
		System.out.println("[1] Yes");
		System.out.println("[2] No");
		selSet=scan.nextInt();
		
		if(selSet==1) 
			SideList();
		else {
			int total=burgers[Bsel-1].price;
			Order o=new Order(UserSel,burgers[Bsel-1].name,"N","N", total);
			orderlist.add(o);//리스트에 추가한다.
			checkOut();}
		//세트 선택 여부 확인
	}
	public void SideList() {
		
		System.out.println(title+" : 사이드 메뉴 목록 - 상품 선택");
		System.out.println("=========================");
		int i=1;
		
		for (Menu s: sides) {//버거 클래스의 메소드를 활용 (용도가 동일)
			System.out.print("["+i+"]");
			s.printMenu();
			i++;
		}//메뉴 리스트 출력한다.
		
		System.out.println("[h]이전화면");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		switch(sel) {
		
		case "h":BurgerList();break;
		default:
			Ssel = Integer.parseInt(sel);
			DrinkList();
		}
		
		
	}
	public void DrinkList() {	
		System.out.println(title+" : 음료 목록 - 상품 선택");
		System.out.println("=========================");
		int i=1;
		
		for (DrinkMenu d: drinks) {
			System.out.print("["+i+"]");
			d.printMenu();
			i++;
		}//메뉴 리스트 출력한다.
		
		
		System.out.println("[h]이전화면");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		
		switch(sel) {
		case "h":BurgerList();break;
		default:
			Dsel = Integer.parseInt(sel);
		}
		int total=burgers[Bsel-1].price+2000+sides[Ssel-1].addCost;
		Order o=new Order(UserSel,burgers[Bsel-1].name,sides[Ssel-1].name,drinks[Dsel-1].name, total);
		orderlist.add(o);//리스트에 추가한다.
		AddOrder();
	}//DrinkList종료
	public void AddOrder() {
		System.out.println("[c]주문하기");
		System.out.println("[a]추가주문");
		String sel = scan.next();
		switch(sel) {
		
		case "a":start();break;//추가 주문시 처음으로 돌아간다.
		default:checkOut();
		}
	}//AddOrder종료
	public void checkOut() {
	System.out.println(title+"결제");
	int total2=0;
	for(Order f:orderlist)
	{
		System.out.println("=========주문 내용==========");
		System.out.println(f.selUser);
		System.out.println("버거세트  : "+ f.selB);
		System.out.println("사이드 : "+f.selS);
		System.out.println("음료 : "+ f.selD);
		System.out.println("총액 : "+f.cost);
		total2=total2+f.cost;
	}
	System.out.println("총 결제 금액  : "+total2 );
	
	System.out.println("[q]결제 완료");
	System.out.print("선택 : ");
	String sel = scan.next();

	switch(sel) {
	case "q":
		String savestring="";
		int earn=0;
	        try {
	            FileWriter writer = new FileWriter(file, true);
	            for(Order s:orderlist)
	            {
	            savestring=s.selUser+"\t"+s.selB+"\t"+s.selS+"\t"+s.selD+"\t"+s.cost;
	            writer.write(savestring+"\n");
	            earn=earn+s.cost;
	            }
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
			System.out.println("## 결제가 완료 되었습니다. 주문이 성공적으로 들어갔습니다. ##");
			orderlist.clear();
			System.out.println("#############################################");
			start();break;//키오스크는 계속 주문을 받기 때문에 종료를 시키지 않는다.
	default: checkOut();
}	
	
	}

	@Override
	public void genBurger() {
		// TODO Auto-generated method stub
		Burger bg = new Burger("그냥버거", 4000);
		burgers[0] = bg;
		bg = new Burger("치킨버거", 5000);
		burgers[1] = bg;
		bg = new Burger("불고기버거", 4500);
		burgers[2] = bg;
		bg = new Burger("새우버거", 4800);
		burgers[3] = bg;
	}//버거 종류를 미리 추가한다.
	@Override
	public void genSide() {
		// TODO Auto-generated method stub
		SideMenu sm= new SideMenu("감자 튀김", 0);
		sides[0]=sm;
		sm= new SideMenu("치즈 스틱",500);
		sides[1]=sm;
		sm= new SideMenu("오징어 튀김",700);
		sides[2]=sm;
		sm= new SideMenu("양념 감자",500);
		sides[3]=sm;
	}//사이드 메뉴 추가
	@Override
	public void genDrink() {
		// TODO Auto-generated method stub
		DrinkMenu dr=new DrinkMenu("콜라");
		drinks[0]=dr;
		dr=new DrinkMenu("사이다");
		drinks[1]=dr;
		dr=new DrinkMenu("환타");
		drinks[2]=dr;
		//음료 추가
	}
}
