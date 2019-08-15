package javapj;

import java.util.Scanner;

public class MyClassroom implements IClassroom { //강의실 확인 프로그램

	User[] users = new User[2];

	Room[] rooms = new Room[4];
	Scanner scan = new Scanner(System.in);
	int selUser;
	String title;

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void genUser() { //사용자 데이터
		User user = new User("이호정", UserType.Professor);
		users[0] = user;
		user = new User("원지훈", UserType.Student);
		users[1] = user;
	}

	@Override
	public void genRoom() { //강의실 데이터
		Lab la = new Lab("409호", 40, 25);
		rooms[0] = la;

		la = new Lab("408호", 30, 20);
		rooms[1] = la;

		Normal no = new Normal("501호", 60, 30);
		rooms[2] = no;

		no = new Normal("502호", 60, 50);
		rooms[3] = no;
	}

	@Override
	public void start() { //메인화면 메서드
		System.out.println(title + " : 메인화면 - 계정선택");
		System.out.println("===============================");
		int i = 0;

		for (User u : users) {
			System.out.printf("[%d]%s(%s)\n", i++, u.getName(), u.getUserType());
		}

		System.out.println("[x] 종 료");
		System.out.print("선택 :");
		String sel = scan.next();
		System.out.println("##" + sel + "선택##");

		switch (sel) {
		case "x":
			System.exit(0);
			break;
		default:
			selUser = Integer.parseInt(sel);
			RoomList();
		}
	}

	public void RoomList() { //강의실 목록 메서드
		System.out.println(title + " : 강의실목록 - 강의실 선택");
		System.out.println("===============================");
		int i = 0;

		for (Room p : rooms) {
			System.out.print("[" + i + "]");
			p.printDetail();
			i++;
		}
		System.out.printf("\n");
		System.out.println("[h]메인화면");
		System.out.println("[숫자]강의실 정보 확인");
		System.out.println("[x]강의실 확인 종료");
		System.out.print("선택 :");
		String sel = scan.next();
		System.out.println("## " + sel + "선택 ##");

		switch (sel) {
		case "h":
			start();
			break;
		case "0":
			System.out.println("C++ 강의실입니다. \n");
			RoomList();
			break;
		case "1":
			System.out.println("JAVA 강의실입니다.\n");
			RoomList();
			break;
		case "2":
			System.out.println("컴퓨터구조 강의실입니다.\n");
			RoomList();
			break;
		case "3":
			System.out.println("운영체제 강의실입니다.\n");
			RoomList();
			break;
		case "x":
			System.out.println("## 강의실 확인이 완료 되었습니다. 종료합니다 ##");
			System.exit(0);
			break;

		}

	}

}
