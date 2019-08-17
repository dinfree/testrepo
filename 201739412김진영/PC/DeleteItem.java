package PC;

import java.util.Scanner;

public class DeleteItem {	// 상품 삭제를 위한 클래스
	Scanner scan = new Scanner(System.in);
	
	public void delete() {	// 상품삭제 리스트 구성
		System.out.println("== 상품삭제 ============================");
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
				foodDelete();
				break;
			case 2:
				snackDelete();
				break;
			case 3:
				drinkDelete();
				break;
		}
	}
	
	public void foodDelete() {		// [식사류] 항목의 삭제를 위한 메소드
		int num;
		FoodItem tfood = new FoodItem();	// foodlist의 세부항목을 가져오기 위한 임시 인스턴스
		
		System.out.println("** FOOD ****************************");	// foodlist 항목을 표시
		for(int i=0; i<Launcher.o.foodlist.size(); i++) {
			tfood = Launcher.o.foodlist.get(i);
			num = i+1;
			System.out.printf("[%d] %s \n", num, tfood.name);
		}
		System.out.println("[b] 이전");
		System.out.println("************************************");
		System.out.print("삭제할 항목을 선택하세요 >> ");
		String in = scan.next();
		if(in.equals("b")) {
			Launcher.o.order_listView();
		}
		
		int i = Integer.parseInt(in);
		int index = i-1;
		Launcher.o.foodlist.remove(index);
		System.out.println("※ 삭제가 완료되었습니다 ※");
		Launcher.start();
	}
	
	public void snackDelete() {		// [과자류] 항목의 삭제를 위한 메소드
		int num;
		SnackItem tsnack = new SnackItem();	// snacklist의 세부항목을 가져오기 위한 임시 인스턴스
		
		System.out.println("** SNACK ***************************");	// snacklist 항목을 표시
		for(int i=0; i<Launcher.o.snacklist.size(); i++) {
			tsnack = Launcher.o.snacklist.get(i);
			num = i+1;
			System.out.printf("[%d] %s \n", num, tsnack.name);
		}
		System.out.println("[b] 이전");
		System.out.println("************************************");
		System.out.print("삭제할 항목을 선택하세요 >> ");
		String in = scan.next();
		if(in.equals("b")) {
			Launcher.o.order_listView();
		}
		
		int i = Integer.parseInt(in);
		int index = i-1;
		Launcher.o.snacklist.remove(index);
		System.out.println("※ 삭제가 완료되었습니다 ※");
		Launcher.start();
	}
	
	public void drinkDelete() {		// [음료] 항목의 삭제를 위한 메소드
		int num;
		DrinkItem tdrink = new DrinkItem();	// drinklist의 세부항목을 가져오기 위한 임시 인스턴스
		
		System.out.println("** DRINK ***************************");	// drinklist 항목을 표시
		for(int i=0; i<Launcher.o.drinklist.size(); i++) {
			tdrink = Launcher.o.drinklist.get(i);
			num = i+1;
			System.out.printf("[%d] %s \n", num, tdrink.name);
		}
		System.out.println("[b] 이전");
		System.out.println("************************************");
		System.out.print("삭제할 항목을 선택하세요 >> ");
		String in = scan.next();
		if(in.equals("b")) {
			Launcher.o.order_listView();
		}
		
		int i = Integer.parseInt(in);
		int index = i-1;
		Launcher.o.drinklist.remove(index);
		System.out.println("※ 삭제가 완료되었습니다 ※");
		Launcher.start();
	}
}
