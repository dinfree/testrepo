package test1_1;

import java.util.*;

public class Sugang implements ISugang {
	// User[] users = new User[2];

	ArrayList<User> usera = new ArrayList<User>();
	static int count = 0;
	Subject[] subjects = new Subject[4];

	ArrayList<Subject> cartA = new ArrayList<Subject>();
	ArrayList<Subject> cartB = new ArrayList<Subject>();
	ArrayList<Subject> cartC = new ArrayList<Subject>();

	Scanner scan = new Scanner(System.in);

	int cuser;
	String title;

	public void setTitle(String title) {
		this.title = title;
	}


	public void start() {
		while (true) {
			System.out.println(title + " 수강신청 : 메인화면");
			System.out.println("========================");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 선택");
			System.out.println("3. 수강 신청");
			System.out.println("4. 신청한 과목 보기");
			System.out.println("5. 종료");
			System.out.printf("메뉴 선택: ");

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				if (count >= 3)
					System.out.println("3명 이상의 학생 추가 불가!");
				else {
					genUser();
					count++;
				}
				break;

			case 2:
				int i = 0;
				for (User u : usera) {
					System.out.printf("[%d] 이름: %s, 학번: %s\n", i++, u.getName(), u.getNum());
				}
				System.out.printf("선택: ");
				cuser = scan.nextInt();
				break;
			case 3:
				System.out.println("수강 가능한 총 학점은 6학점 이하입니다.");
				if (cuser == 0)
					productList(cartA);
				else if (cuser == 1)
					productList(cartB);
				else
					productList(cartC);

				break;
			case 4:
				if (cuser == 0)
					checkOut(cartA);
				else if (cuser == 1)
					checkOut(cartB);
				else
					checkOut(cartC);

				break;
			case 5:
				System.exit(0);
				break;

			}
		}
	}

	public void productList(ArrayList<Subject> cart) {
		System.out.println(title + " : 과목 목록 ");
		System.out.println("=========================");
		int i = 0;

		for (Subject p : subjects) {
			System.out.print("[" + i + "]");
			p.printDetail();
			i++;
		}
		System.out.println("=========================");
		System.out.println("[h]메인화면");
		System.out.print("선택 : ");
		String sel = scan.next();
		
		int total = 0;
			for (Subject p : cart) {
			total = total + p.credit;
		}
			int psel = Integer.parseInt(sel);
			
			if(total+psel>6) {
				System.out.println("신청 가능한 학점을 초과하여 메인메뉴로 돌아갑니다.");
				sel="h";
			}

		switch (sel) {
		case "h":
			start();
			break;
		default:
			cart.add(subjects[psel]);
		//	System.out.println(subjects[psel].credit);
			productList(cart);
		}
	}

	public void checkOut(ArrayList<Subject> cart) {
		System.out.println(title + " : 신청한 과목");
		System.out.println("=========================");
		int total = 0;
		int i = 0;

		for (Subject p : cart) {
			System.out.printf("[%d] 과목명: %s, 교수명: %s, 학점: %d \n", i++, p.sname, p.pname, p.credit);
			total = total + p.credit;
		}
		System.out.println("=========================");
		System.out.println("학번: " + usera.get(cuser).getNum());
		System.out.println("총 학점: " + total);
		System.out.println("[p]이전 , [q]종료");
		System.out.print("선택 : ");
		String sel = scan.next();

		switch (sel) {
		case "q":
			System.out.println("## 수강신청이 완료 되었습니다. 종료합니다 ##");
			System.exit(0);
			break;
		case "p":
			start();
			break;
		default:
			checkOut(cart);
		}
	}

	public void genUser() {
		System.out.printf("이름 입력: ");
		String name = scan.next();
		System.out.printf("학번 입력: ");
		int num = scan.nextInt();
		
		System.out.println("이름: " + name + "학번: " + num);
		User user = new User(name, num);
		usera.add(user);
	}

	public void genProduct() {
		LiberalArts cp = new LiberalArts("교양수학", "홍길동", "월1, 월2");
		subjects[0] = cp;
		cp = new LiberalArts("교양영어", "김영희", "수1, 수2");
		subjects[1] = cp;
		Major st = new Major("JAVA", "박철수", "화1, 화2");
		subjects[2] = st;
		st = new Major("C언어", "김수장", "목1, 목2");
		subjects[3] = st;
	}
}