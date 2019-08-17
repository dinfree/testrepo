package PC;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {	// 주문하기 기능을 구현하는 클래스
	Scanner scan = new Scanner(System.in);
	ArrayList<FoodItem> foodlist = new ArrayList<>();	// 식사류 메뉴 목록을 저장
	ArrayList<SnackItem> snacklist = new ArrayList<>();	// 과자류 메뉴 목록을 저장
	ArrayList<DrinkItem> drinklist = new ArrayList<>();	// 음료 메뉴 목록을 저장
	
	public Order() {	// 상품의 초기항목 설정을 위해 Order 생성자에서 reset 메소드를 실행합니다.
		resetFood();
		resetSnack();
		resetDrink();
	}
	
	public void resetFood() {	// foodlist의 초기값을 설정하는 메소드
		FoodItem fi = new FoodItem("김치볶음밥", 4500, "국내산 김치로 만든 김치볶음밥!!");
		foodlist.add(fi);
		
		fi = new FoodItem("오므라이스", 4000, "국내산 달걀로 만든 오므라이스!!");
		foodlist.add(fi);
		
		fi = new FoodItem("햄버거", 6000, "미국산 패티로 만든 햄버거!!");
		foodlist.add(fi);
	}
	
	public void resetSnack() {	// snacklist의 초기값을 설정하는 메소드
		SnackItem si = new SnackItem("포카칩", 2000, "감자로 만든 과자!!");
		snacklist.add(si);
		
		si = new SnackItem("팝콘", 1500, "직접 만든 팝콘!!");
		snacklist.add(si);
		
		si = new SnackItem("꼬북칩", 3000, "꼬북이로 만든 과자!!");
		snacklist.add(si);
	}
	
	public void resetDrink() {	// Drink의 초기값을 설정하는 메소드
		DrinkItem di = new DrinkItem("포카리스웨트", 2000, "물보다 빠른 흡수력!!");
		drinklist.add(di);
		
		di = new DrinkItem("아리수", 500, "서울의 수돗물 아리수!!");
		drinklist.add(di);
		
		di = new DrinkItem("비락식혜", 1200, "식...혜...!!");
		drinklist.add(di);
	}
	
	public void order_listView() {		// 주문하기의 항목을 구성
		System.out.println("== 주문하기 ============================");
		System.out.println("[1] 식사류");
		System.out.println("[2] 과자류");
		System.out.println("[3] 음료");
		System.out.println("[4] 시간추가");
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
				foodMenu();
				break;
			case 2:
				snackMenu();
				break;
			case 3:
				drinkMenu();
				break;
			case 4:
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
		System.out.println(seatnum + "번 자리에서 " + addnum + "시간 추가가 완료되었습니다.");
		Launcher.start();
	}
	
	public void foodMenu() {		// [식사류] 메뉴
		int num;
		FoodItem tfood = new FoodItem();	// foodlist의 세부항목을 가져오기 위한 임시 인스턴스
		User tuser = new User();			// User의 세부항목을 가져오기 위한 임시 인스턴스
		
		System.out.println("** FOOD ****************************");	// foodlist 항목을 표시
		for(int i=0; i<foodlist.size(); i++) {
			tfood = foodlist.get(i);
			num = i+1;
			System.out.printf("[%d] %s \n", num, tfood.name);
		}
		System.out.println("[b] 이전");
		System.out.println("************************************");
		System.out.print("선택 >> ");
		String in = scan.next();
		if(in.equals("b")) {
			order_listView();
		}
		int i = Integer.parseInt(in);
		tfood = foodlist.get((i-1));
		tfood.showItem();
		System.out.println("[s] 구매하기, [b] 이전 ");
		System.out.print("선택 >> ");
		String j = scan.next();
		switch(j) {
			case "s":
				System.out.print("자리 번호를 입력하세요 >> ");
				i = scan.nextInt();
				tuser = Launcher.s.userlist.get((i-1));
				tuser.setBuyItem(tfood.price);
				System.out.println(i+"번 자리에서 "+tfood.name+" 구매가 완료되었습니다.");
				Launcher.start();
				break;
			case "b":
				foodMenu();
				break;
		}
		
	}

	public void snackMenu() {		// [과자류] 메뉴
		int num;
		SnackItem tsnack = new SnackItem();	// snacklist의 세부항목을 가져오기 위한 임시 인스턴스
		User tuser = new User();			// User의 세부항목을 가져오기 위한 임시 인스턴스
		
		System.out.println("** SNACK ***************************");	// snacklist 항목을 표시
		for(int i=0; i<snacklist.size(); i++) {
			tsnack = snacklist.get(i);
			num = i+1;
			System.out.printf("[%d] %s \n", num, tsnack.name);
		}
		System.out.println("[b] 이전");
		System.out.println("************************************");
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
				System.out.println(i+"번 자리에서 "+tsnack.name+" 구매가 완료되었습니다.");
				Launcher.start();
				break;
			case "b":
				foodMenu();
				break;
		}
	}
	
	public void drinkMenu() {		// [음료] 메뉴
		int num;
		DrinkItem tdrink = new DrinkItem();	// drinklist의 세부항목을 가져오기 위한 임시 인스턴스
		User tuser = new User();			// User의 세부항목을 가져오기 위한 임시 인스턴스
		
		System.out.println("** DRINK ***************************");	// drinklist 항목을 표시
		for(int i=0; i<drinklist.size(); i++) {
			tdrink = drinklist.get(i);
			num = i+1;
			System.out.printf("[%d] %s \n", num, tdrink.name);
		}
		System.out.println("[b] 이전");
		System.out.println("************************************");
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
				System.out.println(i+"번 자리에서 "+tdrink.name+" 구매가 완료되었습니다.");
				Launcher.start();
				break;
			case "b":
				foodMenu();
				break;
		}
	}
}
