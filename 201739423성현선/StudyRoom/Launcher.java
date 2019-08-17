package StudyRoom;

import java.util.Scanner;

public class Launcher {
	static Seat s = new Seat();
	static Order o = new Order();
	
	
	public static void start() {
		Payment p = new Payment();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("──────── 스터디룸 프로그램 ──────────────────────────────");
		System.out.println("\n");
		System.out.println("[1] 자리선택");
		System.out.println("[2] 주문메뉴");
		System.out.println("[3] 결제하기");
		System.out.println("[4] 종료");
		System.out.println("\n");
		System.out.println("───────────────────────────────────────────────────");
		System.out.print("선택 >> ");
		int i = scan.nextInt();
		
		switch(i) {
			case 1:
				s.infoSeat();
				s.infoSelect();
				break;
			case 2:
				o.order_listView();
				break;
			case 3:
				p.PayMoney();
				break;
			case 4:
				System.out.print("※ 프로그램을 종료합니다. ※");
				System.exit(0);
		}
		scan.close();
	}
	public static void main(String[] args) {
		Launcher.start();

	}

}
