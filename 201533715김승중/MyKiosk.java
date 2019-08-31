package Kiosk;

import java.util.ArrayList;
import java.util.Scanner;

import javabasic.week2.wed.Product;


public class MyKiosk {
	Brito[] products = new Brito[9];
	
	Scanner scan = new Scanner(System.in);
	
	// 상품 추가를 위한 장바구니
	ArrayList<Brito> cart = new ArrayList<Brito>();
		
	//WhereEat 인덱스 정보 저장
	int where;
	
	//Meat 인덱스 정보 저장
	static int meatNo;
	
	//SpicyLevel 인덱스 정보 저장
	int spicyLevel;
	
	public void start() {
		System.out.println("      가천대       브리또     ");
		System.out.println("========================");
		System.out.println(" [0] 포장	   [1] 매장식사");
		System.out.println("[x]종 료");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "x": System.exit(0);break;
			default:
				where = Integer.parseInt(sel);
				selectMenu();
		}
	}
	
	public void selectMenu() {
		System.out.println("     상품 목록 - 고기 종류 선택");
		System.out.println("=========================");
		
		//고기 종류 선택
		System.out.println("    [0] 닭고기 ");
		System.out.println("    [1] 소고기 ");
		System.out.println("    [2] 믹스 ");
		System.out.println("    [h]메인화면");
		System.out.println("    [c]체크아웃");
		System.out.print("    선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "h":start();break;
			case "c":checkOut();break;
			default:
				meatNo = Integer.parseInt(sel);
				selectSpicy();
		}
	}
	public void selectSpicy() {
		System.out.println("     상품 목록 - 맵기 정도 선택");
		System.out.println("=========================");
		
		//고기 종류 선택
		System.out.println("    [0] 순한맛 ");
		System.out.println("    [1] 조금매운맛 ");
		System.out.println("    [2] 매운맛 ");
		System.out.println("    [h]메인화면");
		System.out.println("    [c]체크아웃");
		System.out.print("    선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "h":start();break;
			case "c":checkOut();break;
			default:
				int spicyLevel = Integer.parseInt(sel);
				if(meatNo == 0) {
					cart.add(products[spicyLevel]);
				}
				else if(meatNo == 1) {
					cart.add(products[spicyLevel+3]);
				}
				else if(meatNo == 2) {
					cart.add(products[spicyLevel+6]);
				}
				selectMenu();
		}
		
	}
	
	public void checkOut() {
		System.out.println("         체크아웃");
		System.out.println("=========================");
		int total=0;
		int i =0;
		// 장바구니에 등록된 상품 정보 출력
		for(Brito b : cart) {
			System.out.printf("[%d]%s(%s) - %d원\n",i++,b.meat,b.spicyLevel, b.printPrice(b.meat));
			total = total + b.printPrice(b.meat);
		}
		System.out.println("=========================");
		
		// 선택한 사용자의 포장 유무에 따라 할인 적용
		if(where == 0) {
			System.out.println("[포장] 선택으로 1000원 할인 되었습니다.");
			total -= 1000;
		}
		
		// 합계 출력
		System.out.println("합계: "+total+" 원 입니다.");
		System.out.println("[p]이전 , [q]결제 완료");
		System.out.print("선택 : ");
		String sel = scan.next();

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "q":
					System.out.println("## 결제가 완료 되었습니다. 종료합니다 ##");
					System.exit(0);break;
			case "p":selectMenu();break;
			default: checkOut();
		}		
	}
	
	public void genProduct() {
		Brito br = new Brito("chicken","noSpicy");
		products[0] = br;
		br = new Brito("chicken","littleSpicy");
		products[1] = br;
		br = new Brito("chicken","Spicy");
		products[2] = br;
		
		br = new Brito("meat","noSpicy");
		products[3] = br;
		br = new Brito("meat","littleSpicy");
		products[4] = br;
		br = new Brito("meat","Spicy");
		products[5] = br;
		
		br = new Brito("mix","noSpicy");
		products[6] = br;
		br = new Brito("mix","littleSpicy");
		products[7] = br;
		br = new Brito("mix","Spicy");
		products[8] = br;
	}
}
