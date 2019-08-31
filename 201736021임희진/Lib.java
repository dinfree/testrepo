package javabasic.library;

import java.util.Scanner;

public class Lib {
	User[] users = new User[2];
	Book[] books = new Book[8];
	Scanner sc = new Scanner(System.in);
	String sel; 
	User user;
	Boolean isRun = true;
	
	public void run() {
		while(isRun) {
			System.out.println("-----------------------------------------");
			System.out.println("[0]: 대여 가능한 도서 수 확인\n[1]: 도서 검색\n[2]: 도서 대여\n[3]: 도서 반납\n[q]: 종료");
			System.out.printf("원하는 작업의 번호를 입력하세요: ");
			sel = sc.next();
			
			
			switch(sel) {
			case "0": // 대여 가능한 도서수 확인
				System.out.println("-----------------------------------------");
				System.out.printf("대여 가능한 도서 수를 확인합니다.\n사용자 id(학번)을 입력하세요: ");
				int id = sc.nextInt();
				int cnt=0;
				for(User user : users) {
					if(user.getId() == id) {
						System.out.println(user.getName()+"님 대출 가능한 도서는 "+user.getCount()+"권 입니다.");
						cnt=1;
					}
				}
				if(cnt != 1) 
					System.out.println("존재하지 않는 id(학번)입니다.");	
				break;
				
			case "1": // 도서 검색
				System.out.println("-----------------------------------------");
				System.out.println("[0]: 도서명으로 검색\n[1]: 도서 분류로 검색");
				System.out.printf("검색 방법을 선택하세요: ");
				int sel = sc.nextInt(); // nextInt()는 마지막에 입력된 개행문자를 제거하지 않음
				boolean flag1 = false;
				switch(sel) {
				case 0: // 도서명으로 검색
					System.out.println("-----------------------------------------");
					System.out.printf("도서명을 입력하세요(띄어쓰기 주의!): ");
					sc.nextLine(); // 개행문자 제거하기 위해
					String title = sc.nextLine();
					for(Book book : books) {
						if(book.getTitle().contentEquals(title))  {
							System.out.println("도서코드: "+book.getCode()+"\n도서명: "+book.getTitle()
							+"\n저자: "+book.getAuthor()+"\n분류: "+book.getClassif()+"\n대여 가능 여부(true면 가능): "+book.getAvailability());
							flag1 = true;
						}
					}
					if(flag1 == false)
						System.out.println("없는 도서입니다.");
					break;
					
				case 1: // 도서 분류로 검색
					System.out.println("-----------------------------------------");
					System.out.println("[1]: 철학\n[2]: 과학\n[3]: 역사\n[4]: 문학");
					System.out.println("원하는 도서 분류를 선택하세요: ");
					int s = sc.nextInt();
					switch(s) {
					case 1:
						printBook(Classification.philosophy);
						break;
					case 2:
						printBook(Classification.science);
						break;
					case 3:
						printBook(Classification.history);
						break;
					case 4:
						printBook(Classification.literature);
						break;
					}				
			    }
				break;
				
			case "2": // 도서 대여
				checkUser(); // 사용자 확인
				if(user.getCount()<1) {
					System.out.println("도서 대여가 불가능한 상태입니다..");
					break;
				}
				System.out.printf("대여를 원하는 도서 코드를 입력하세요: ");
				int code = sc.nextInt();
				boolean flag2 = false;
				for(Book book : books) {
					if(book.getCode()==code && book.getAvailability()==true) {
						System.out.println(book.getTitle()+"은(는) 대여 가능한 도서입니다.");
						System.out.println("해당 도서를 대여하시겠습니다?[y/n]: ");
						String a = sc.next();
						switch(a) {
						case "y":
							user.downCount();
							book.setAvailability(false);
							System.out.println("대여 처리되었습니다.");
							flag2 = true;
							break;
						case "n":
							System.out.println("취소되었습니다.");
							flag2 = true;
						}
					}
				}
				if(flag2 == false) {
					System.out.println("빌릴 수 없는 도서입니다.");
				}
				break;
				
			case "3": // 도서 반납
				checkUser(); // 사용자 확인
				System.out.printf("반납하고자 하는 도서 코드를 입력하세요: ");
				code = sc.nextInt();
				boolean flag3 = false;
				for(Book book : books) {
					if(book.getCode()==code) {
						book.setAvailability(true);
						user.upCount();
						System.out.println("반납되었습니다.");
						flag3 = true;
					}
				}
				if(flag3 == false) {
					System.out.println("잘못 입력하셨습니다.");
				}
				break;
				
			case "q": // 종료
				System.exit(0);
				break;
			}
		} 
	}
	
	public void genUser() { // 사용자 생성
		User user = new User("홍길동", 20170101);
		users[0] = user;
		user = new User("김영희", 20190101);
		users[1] = user;
	}
	
	public void genBook() { // 도서 생성
		Book book = new Book("철학의 역사",1001,"아이절 워버턴",Classification.philosophy);
		books[0] = book;
		book = new Book("철학이 필요한 순간",1002,"아이절 워버턴",Classification.philosophy);
		books[1] = book;
		book = new Book("정재승의 과학 콘서트",2001,"정재승",Classification.science);
		books[2] = book;
		book = new Book("이기적 유전자",2002,"리처드 도킨슨",Classification.science);
		books[3] = book;
		book = new Book("설민석의 조선왕조실록",3001,"설민석",Classification.history);
		books[4] = book;
		book = new Book("나의 한국현대사",3002,"유시민",Classification.history);
		books[5] =book;
		book = new Book("마음이 살짝 기운다",4001,"나태주",Classification.literature);
		books[6] = book;
		book = new Book("트랙과 들판의 별",4002,"황병승",Classification.literature);
		books[7] = book;
	}
	
	public void checkUser() { // 사용자 확인
		System.out.printf("사용자 id(학번)을 입력하세요: ");
		int id = sc.nextInt();
		if(users[0].getId() == id) {
			user = users[0];
			System.out.println("안녕하세요. "+user.getName()+"님!");
		}
		else if(users[1].getId() == id) {
			user = users[1];
			System.out.println("안녕하세요. "+user.getName()+"님!");
		}
		else 
			System.out.println("존재하지 않는 id(학번)입니다.");
	}
	
	public void printBook(Classification a) { // 도서 정보 출력
		for(Book book: books) {
			if(book.getClassif() == a)
				System.out.println("도서코드: "+book.getCode()+"\n도서명: "+book.getTitle()
				+"\n저자: "+book.getAuthor()+"\n분류: "+book.getClassif()+"\n대여 가능 여부(true면 가능): "+book.getAvailability());
		}
	}
}
