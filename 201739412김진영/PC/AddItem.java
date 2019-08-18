package PC;

import java.util.Scanner;
import java.util.StringTokenizer;

public class AddItem {	// 상품 추가를 위한 클래스
	Scanner scan = new Scanner(System.in);
	
	public void add_listView() {	// 상품등록 리스트 구성
		System.out.println("== 상품등록 ============================");
		System.out.println("[1] 식사류");
		System.out.println("[2] 과자류");
		System.out.println("[3] 음료");
		System.out.println("[b] 이전");
		System.out.println("=====================================");
		
		System.out.print("선택 >> ");
		String in = scan.next();
		if(in.equals("b")) {
			Launcher.start();
		}
		int i = Integer.parseInt(in);
		
		switch(i) {
			case 1 :
				foodAdd();
				break;
			case 2:
				snackAdd();
				break;
			case 3:
				drinkAdd();
				break;
		}
		
	}
	
	public void foodAdd() {		// [식사류] 항목의 추가를 위한 메소드
		System.out.println("[식사류] 등록: 상품명, 가격, 비고 형식으로 입력하세요.");
		System.out.print("입력 >> ");
		String entry = scan.next();
		StringTokenizer st = new StringTokenizer(entry, ",");
		
		FoodItem tfood = new FoodItem();
		tfood.name=st.nextToken();
		tfood.price=Integer.parseInt(st.nextToken());
		tfood.remarks=st.nextToken();
		Launcher.o.foodlist.add(tfood);
		System.out.println("[" + tfood.name + "] 상품 등록이 완료되었습니다.");
		Launcher.start();
	
	}
	
	public void snackAdd() {	// [과자류] 항목의 추가를 위한 메소드
		System.out.println("[과자류] 등록: 상품명, 가격, 비고 형식으로 입력하세요.");
		System.out.print("입력 >> ");
		String entry = scan.next();
		StringTokenizer st = new StringTokenizer(entry, ",");
		
		SnackItem tsnack = new SnackItem();
		tsnack.name=st.nextToken();
		tsnack.price=Integer.parseInt(st.nextToken());
		tsnack.remarks=st.nextToken();
		Launcher.o.snacklist.add(tsnack);
		System.out.println("[" + tsnack.name + "] 상품 등록이 완료되었습니다.");
		Launcher.start();
	
	}
	
	public void drinkAdd() {	// [음료] 항목의 추가를 위한 메소드
		System.out.println("[음료] 등록: 상품명, 가격, 비고 형식으로 입력하세요.");
		System.out.print("입력 >> ");
		String entry = scan.next();
		StringTokenizer st = new StringTokenizer(entry, ",");
		
		DrinkItem tdrink = new DrinkItem();
		tdrink.name=st.nextToken();
		tdrink.price=Integer.parseInt(st.nextToken());
		tdrink.remarks=st.nextToken();
		Launcher.o.drinklist.add(tdrink);
		System.out.println("[" + tdrink.name + "] 상품 등록이 완료되었습니다.");
		Launcher.start();
	
	}
}
