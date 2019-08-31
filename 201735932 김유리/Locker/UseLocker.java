package locker;

import java.util.*;
import locker.*;

public class UseLocker implements ILocker {
	
	LockerNumber[] numbers = new LockerNumber[3];
	BelDetail[] bels = new BelDetail[4];
	
	ArrayList<BelDetail> cart = new ArrayList<BelDetail>();
	Scanner scan = new Scanner(System.in);
	int usedLocker;
	String title;

	@Override
	public void setTitle(String title) {
		this.title = title;

	}
	
	@Override
	public void start() {
		System.out.println(title+" : 메인화면 - 계정 선택");
		System.out.println("========================");
		
		// 등록된 사용자 정보 출력
		for(LockerNumber n : numbers) {
			System.out.printf("%s 번 사물함 (%s)\n",n.getName(),n.getPayType());
		}
		
		System.out.println("[x]종 료");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "x": System.exit(0);break;
			default:
				usedLocker = Integer.parseInt(sel);
				productList();
		}

	}
	
	public void productList() {
		System.out.println(title+" : 소지품 목록 - 선택");
		System.out.println("=========================");
		int i=1;
		
		// 등록된 상품 정보 출력
		for(BelDetail b : bels) {
			System.out.print("["+i+"]");
			b.printDetail();
			i++;
		}
		System.out.println("[h]메인화면");
		System.out.println("[c]체크아웃");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "h":start();break;
			case "c":checkOut();break;
			default:
				int psel = Integer.parseInt(sel);
				cart.add(bels[psel]);
				productList();
		}
	}
	
	public void checkOut() {
		System.out.println(title+" : 체크아웃");
		System.out.println("=========================");
		int total=0;
		int i=1;
		
		// 장바구니에 등록된 상품 정보 출력
		for(BelDetail p : cart) {
			System.out.printf("[%d]%s\n",i++,p.oname);
			total++;
		}
		System.out.println("=========================");
		
		// 합계 출력
		System.out.println("합계: "+total+" 개 보관하였습니다.");
		System.out.println("## 종료합니다. 이용해주셔서 감사합니다. ##");
	}

	@Override
	public void genUser() {
		LockerNumber number = new LockerNumber("1", Available.사용가능);
		numbers[0] = number;
		number = new LockerNumber("2", Available.사용가능);
		numbers[1] = number;
		number = new LockerNumber("3", Available.사용가능);
		numbers[2] = number;
	}

	@Override
	public void genProduct() {
		BelDetail bel = new BelDetail("전공책");
		bels[0] = bel;
		bel = new BelDetail("필기노트");
		bels[1] = bel;
		bel = new BelDetail("필통");
		bels[2] = bel;
		bel = new BelDetail("노트북");
		bels[3] = bel;
	}

	

}
