package PC;

import java.util.Scanner;

public class Payment {	// 결제하기 기능을 구현하는 클래스
	Scanner scan = new Scanner(System.in);
	User tuser = new User();	
	int ptime, ptimepay, pbuyitem, sum;
	String pseat;
	
	public void PayMoney() {
		System.out.print("결제하실 자리 번호를 입력하세요 >> ");
		int select = scan.nextInt();
		int index = select-1;
		
		tuser = Launcher.s.userlist.get(index);
		pseat = tuser.getSeatNum();
		ptime = tuser.getUseTime();
		ptimepay = ptime * 1000;
		pbuyitem = tuser.getBuyItem();
		sum = ptimepay + pbuyitem;
		
		System.out.println("=====================================");
		System.out.println("\t자리번호 : " + select + "번");
		System.out.println("\t이용시간 : " + ptime + "시간(" + ptimepay + "원)");
		System.out.println("\t상품구매 : " + pbuyitem + "원");
		System.out.println("-------------------------------------");
		System.out.println("\t합계금액 : " + sum + "원");
		System.out.println("=====================================");
		
		System.out.print("결제하겠습니까? (y/n) >> ");
		String in = scan.next();
		
		if(in.equals("y")) {
			User resetUser = new User();
			resetUser.setSeatNum(Integer.toString(select));
			Launcher.s.userlist.set(index, resetUser);		// 결제가 완료되면 자리목록에서 해당 자리가 "*"로 설정되어있던 것이 다시 자리 번호로 바뀌게된다.
			System.out.println("결제가 완료되었습니다. 안녕히가세요!!!");
			Launcher.start();
		} else {
			Launcher.start();
		}
	}
}
