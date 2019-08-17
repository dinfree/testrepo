package Project;

import java.util.*;

public class Shop implements IYupDduck {
	YupDduck[] ydduck = new YupDduck[5];
	Toping[] ytoping = new Toping[5];
	ArrayList<Product> cart = new ArrayList<Product>();
	Scanner scan = new Scanner(System.in);

	public void start() {
		System.out.println("          **상품 목록**");
		System.out.println("====================================");
		int i = 0;

		for (Product y : ydduck) {
			System.out.print("["+i+"]");
			y.printDetail();
			i++;
			
		}
		System.out.println("[s] 사리 추가하기 ");
		System.out.println("[x] 종료");
		System.out.print("선택 상품 : ");
		String select = scan.next();
		System.out.println("" + select + "을 선택하셨습니다.");

		switch (select) {
		case "s":
			plusProduct();
			break;
		case "x":
			payment();
			break;
		default:
			int ysel = Integer.parseInt(select);
			cart.add(ydduck[ysel]);
			start();
		}
	}

	public void plusProduct() {
		int i = 0;

		for (Product y : ytoping) {
			System.out.print("["+i+"]");
			y.printDetail();
			i++;
		}
		System.out.println("[h] 결제하기");
		System.out.println("[r] 처음 화면으로 돌아가기");
		System.out.println("[x] 종료");
		System.out.print("선택  : ");
		String select = scan.next();
		System.out.println("" + select + "을 선택하셨습니다.");

		switch (select) {
		case "h":
			payment();
			break;
		case "r":
			start();
			break;
		case "x":
			System.exit(0);
			break;
		default:
			int ysel = Integer.parseInt(select);
			cart.add(ytoping[ysel]);
			plusProduct();
		}
	}
	
	public void payment() {
		System.out.println("==============================");
		System.out.println("결제 창입니다.");
		System.out.println("선택 하신 상품은 아래와 같습니다.");
		int total = 0;
		int i = 0;

		for (Product y : cart) {
			System.out.printf("[%d]%s : %s\n", i++, y.yname, y.price);
			total = total + y.price;

		}

		System.out.println("총 금액은 : " + total + "원 입니다.");
		System.out.println("[3]돌아가기");
		System.out.println("[4]결제하기");
		String select = scan.next();

		switch (select) {
		case "3":
			start();
			break;
		case "4":
			System.out.println("결제가 완료되었습니다.");
			System.exit(0);
			break;
		}
	}

	public void genProduct() {
		YupDduck yd = new YupDduck("엽기 떡볶이", 14000, "착한 맛");
		ydduck[0] = yd;
		yd = new YupDduck("엽기 떡볶이", 14000, "순한 맛");
		ydduck[1] = yd;
		yd = new YupDduck("엽기 떡볶이", 14000, "중간 맛");
		ydduck[2] = yd;
		yd = new YupDduck("엽기 떡볶이", 14000, "매운 맛");
		ydduck[3] = yd;
		yd = new YupDduck("엽기 떡볶이", 14000, "지옥 맛");
		ydduck[4] = yd;
	}

	public void genToping() {
		Toping yt = new Toping("추가 상품", 2000, "우동 사리");
		ytoping[0] = yt;
		yt = new Toping("추가 상품", 2000, "라면 사리");
		ytoping[1] = yt;
		yt = new Toping("추가 상품", 2000, "치즈 추가");
		ytoping[2] = yt;
		yt = new Toping("추가 상품", 2000, "소세지");
		ytoping[3] = yt;
		yt = new Toping("추가 상품", 2000, "쥬시쿨");
		ytoping[4] = yt;
	}
}
