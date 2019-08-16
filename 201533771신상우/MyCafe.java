package javabasic.project;

import java.util.ArrayList;
import java.util.Scanner;


public class MyCafe implements IShop {
		
		// 등록 음료 정보 배열
		Beverage[] beverages = new Beverage[6];
		
		// 음료 추가를 위한 장바구니
		ArrayList<Beverage> cart = new ArrayList<Beverage>();
			
		// 키보드 입력으로 문자열 입력받기 위한 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);
		
		// 카페 이름
		String title;
		
		public void setTitle(String title) {
			this.title = title;
		}
		
		/**
		 * 프로그램 메인 시작 메서드
		 */
		public void start() {
			System.out.println("\n"+title);
			System.out.println("=========================");
			int i=0;
			
			// 등록된 상품 정보 출력
			for(Beverage b : beverages) {
				System.out.print("["+i+"]");
				b.printDetail();
				i++;
			}
			System.out.println("[c]체크아웃");
			System.out.println("[x]종료");
			System.out.print("선택 : ");
			String sel = scan.next();
			System.out.println("## "+sel+" 선택 ##");

			// 선택된 메뉴에 따라 처리
			switch(sel) {
				case "x": System.exit(0);break;
				case "c":checkOut();break;
				default:
					int bsel = Integer.parseInt(sel);
					// 음료 타입 선택
					String s = selType();
					// 휘핑 음료 질문
					if(bsel == 4 || bsel == 5) {
					beverages[bsel]= selWhip(bsel);
					}
					beverages[bsel].type = s;
					cart.add(beverages[bsel]);
					start();
			}
		}
		
		/**
		 * 결제 진행을 위한 체크아웃 처리 메서드
		 */
		public void checkOut() {
			System.out.println(title+" : 체크아웃");
			System.out.println("=========================");
			int total=0;
			int i=0;
			
			// 장바구니에 등록된 상품 정보 출력
			for(Beverage b : cart) {
				System.out.printf("[%d]%s(%s) : %s\n",i++,b.bname, b.type, b.price);
				b.printExtra();
				total = total + b.price;
			}
			System.out.println("=========================");
			
			// 합계 출력
			System.out.println("합계: "+total+" 원 입니다.");
			// 선택한 사용자의 결제 방법 출력
						System.out.printf("결제 방법 선택 ( [1]CARD, [2]CASH ) : ");
						String c = scan.next();
						PayType p = PayType.CARD;
						switch(c) {
						case"1": p = PayType.CARD;break;
						case"2": p = PayType.CASH;break;
						}
						System.out.println(p +" 결제");
			System.out.println("[p]이전 , [q]결제 완료");
			System.out.print("선택 : ");
			String sel = scan.next();

			// 선택된 메뉴에 따라 처리
			switch(sel) {
				case "q":
						System.out.println("## 결제가 완료 되었습니다. 종료합니다 ##");
						System.exit(0);break;
				case "p":start();break;
				default: checkOut();
			}		
		}
		
		/**
		 *  프로그램에서 사용하기 위한 예제 상품 등록 메서드
		 */
		public void genProduct() {
			Americano am = new Americano("OG 아메리카노", 4000, "오리지널 원두");
			beverages[0] = am;
			am = new Americano("SP 아메리카노", 4000, "스페셜 원두");
			beverages[1] = am;
			Latte lt = new Latte("라떼", 4500, "기본");
			beverages[2] = lt;
			lt = new Latte("바닐라 라떼", 5000, "바닐라 시럽");
			beverages[3] = lt;
			Moca mc = new Moca("모카", 5000, "다크 초콜릿",true);
			beverages[4] = mc;
			mc = new Moca("화이트 모카", 5500, "화이트 초콜릿",true);
			beverages[5] = mc;
		}
		
		// 음료 타입 고르는 메서드
		public String selType() {
			System.out.print("\n HOT or ICE?: ");
			
			String selec = scan.next();
			System.out.println("\n" + selec +" 선택");
			return selec;
		}
		
		// 모카 종류 음료 휘핑크림 여부
		public Moca selWhip(int bsel) {
			Moca mc = new Moca();
			if(bsel == 4) {
				System.out.print(" 휘핑 크림 올려드릴까요? (y/n): ");
				String a = scan.next();
				System.out.println(a+" 선택");
				switch (a) {
				case "y": mc = new Moca("모카", 5000, "다크 초콜릿",true); break;
				case "n": mc = new Moca("모카", 5000, "다크 초콜릿",false); break;
				}
			} else if (bsel == 5) {
					System.out.print(" 휘핑 크림 올려드릴까요? (y/n): ");
					String a = scan.next();
					System.out.println(a+" 선택");
					switch (a) {
					case "y": mc = new Moca("화이트 모카", 5500, "화이트 초콜릿",true); break;
					case "n": mc = new Moca("화이트 모카", 5500, "화이트 초콜릿",false); break;
					}
		}
			return mc;
		}
		
}
