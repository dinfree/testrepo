package javabasic.week2.project;
import java.util.*;


public class MyLibrary implements Library {
	User[] users = new User[3];
	Book[] books = new Book[4];
	ArrayList<Book> cart = new ArrayList<Book>();
	Scanner sc = new Scanner(System.in);
	
	String title;
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public void genUser() {
		User user = new User("고길동" , 1);
		users[0] = user;
		user = new User("이길동", 2);
		users[1] = user;
		user = new User("관리자", 3);
		users[2] = user;
	}
	@Override
	public void genBook() {
		ReserveBook rb = new ReserveBook("잭과 콩나무", 0001, "이솝우화", Reserved.예약가능);
		books[0] = rb;
		rb = new ReserveBook("아기돼지 삼형제", 0002, "이솝우화", Reserved.예약불가);
		books[1] = rb;
		SellBook sb = new SellBook("오늘만 산다", 0003, "수필", 10000);
		books[2] = sb;
		sb = new SellBook("내일은 없다", 0004, "수필", 12000);
		books[3] = sb;
	}

	@Override
	public void start() {
		System.out.println(title + " : 메인화면 - 회원 선택");
		System.out.println("=========================");
		int i=0;
		
		for(User u: users) {
			System.out.printf("[%d] %s (회원번호: %d)\n", i++, u.getName(), u.getCno());
		}
		
		System.out.println("[X] 종 료");
		System.out.print("선택 : ");
		String sel = sc.next();
		System.out.println("## [" + sel + "] 선택 ##");
		
		switch(sel) {
		case "2": System.out.println("관리자는 책을 사거나 빌릴 수  없습니다. 사장님께 문의하세요. \n"); start();break;
		case "x": System.exit(0);break;
		default:
			bookList();
		}
	}
	public void bookList() {
			System.out.println(title +" : 도서 목록 - 책 선택 (저희 도서관은 한 책당 여러권을 가지고 있습니다.)");
			System.out.println("=========================");
			int i = 0;
			for(Book b : books) {
				System.out.println("["+i+"]");
				b.printDetail();
				System.out.println("-------------------------");
				i++;
			}
			System.out.println("[h] 메인화면");
			System.out.println("[c] 체크아웃");
			System.out.print("선택 : ");
			
			String sel = sc.next();
			System.out.println("## [" + sel +"] 선택 ##");
			
			switch(sel) {
			case "1": System.out.println("예약되어있습니다.\n"); bookList(); break;
			case "h": System.out.println("취소되었습니다. \n"); start(); break;
			case "c": checkOut();break;
			default:
				int bsel = Integer.parseInt(sel);
				cart.add(books[bsel]);
				bookList();
			}
	}
	public void checkOut() {
			System.out.println(title + " : 체크아웃");
			System.out.println("====================");
			int totalbook = 0;
			int totalprice = 0;
			int rtotal = 0;
			int stotal = 0;
			int i = 0;
			
			for(Book b: cart) {
				System.out.printf("[%d] %s (%d) %s \n", i++, b.bname, b.bno, b.genre);
				totalbook = totalbook + 1;
				if(b.genre.equals("수필")) {
					stotal += 1; 
					if(b.bname.equals("오늘만 산다")) totalprice = totalprice + 10000; 
					if(b.bname.equals("내일은 없다")) totalprice = totalprice + 12000;
					} 
				if(b.genre.equals("이솝우화")) rtotal += 1;
			}
			
			System.out.println("=======================");
			System.out.printf("빌린권수: %d권, 구입권수: %d권\n", rtotal, stotal);
			System.out.println("총 권수: " + totalbook + "권 입니다.");
			System.out.printf("총 구매액: %d\n", totalprice);
			System.out.println("[p]더 보기 , [q]대여완료");
			System.out.print("선택: ");
			String sel = sc.next();
			
			switch(sel) {
			case "q":
				System.out.println("## 대여 및 구매가 완료 되었습니다. 종료합니다. ##");
				System.exit(0);
				break;
			case "p":bookList();break;
			default:
				checkOut();
			}
	}
}