package PC;

import java.util.Scanner;

public class Launcher {
	static Seat s = new Seat();
	static Order o = new Order();
	
	
	public static void start() {
		Payment p = new Payment();
		AddItem a = new AddItem();
		DeleteItem d = new DeleteItem();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("== PC방 프로그램 ========================");
		System.out.println("|\t\t\t\t    |");
		System.out.println("|\t[1] 자리안내\t\t    |");
		System.out.println("|\t[2] 주문하기\t\t    |");
		System.out.println("|\t[3] 상품등록\t\t    |");
		System.out.println("|\t[4] 상품삭제\t\t    |");
		System.out.println("|\t[5] 결제하기\t\t    |");
		System.out.println("|\t[6] 종료\t\t\t    |");
		System.out.println("|\t\t\t\t    |");
		System.out.println("=====================================");
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
				a.add_listView();
				break;
			case 4:
				d.delete();
				break;
			case 5:
				p.PayMoney();
				break;
			case 6:
				System.out.print("※ 프로그램을 종료합니다. ※");
				System.exit(0);
		}
		scan.close();
	}
	public static void main(String[] args) {
		Launcher.start();

	}

}
