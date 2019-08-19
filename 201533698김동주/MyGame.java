package javastudy.game;

import java.util.ArrayList;
import java.util.Scanner;

public class MyGame implements GameMarket {
	User[] users = new User[3];
	Game[] games = new Game[4];
	
	ArrayList<Game> cart = new ArrayList<Game>();
	Scanner scan = new Scanner(System.in);
	int selUser;
	
	public void start() {
		System.out.println(" ## 사용자 선택 ");
		System.out.println("=============================");
		int i = 0;
		
		for(User u : users) {
			System.out.printf("[%d]%s(%s)\n", i++, u.getName(), u.getPayType());
		}
		
		System.out.println("[x]종료");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## " + sel + "선택 ##");
		
		switch(sel) {
		case "x" :
			System.exit(0);
			break;
		default:
			selUser = Integer.parseInt(sel);
			GameList();
		}
	}
	
	public void GameList() {
		int i = 0;
		
		for(Game p : games) {
			System.out.print("[" + i + "]");
			p.printDetail();
			i++;
		}
		System.out.println("[h]결제");
		System.out.println("[c]처음으로");
		System.out.println("[x]종료");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## " + sel + "선택 ##");
		
		switch(sel)	{
		case "h" :
			charge();
			break;
		case "c" :
			start();
			break;
			
	    case "x":
	        System.exit(0);
	        break;
		default:
			int psel = Integer.parseInt(sel);
			cart.add(games[psel]);
			GameList();
		}
	}
	
	public void charge() {
		int total = 0;
		int i = 0;
		
		for(Game g : cart) {
			System.out.printf("[%d]%s(%s)\n", i++, g.gname, g.price);
			total = total + g.price;
		}
		System.out.println("=========================");
		
		System.out.println("결제 방법: " + users[selUser].getPayType());
		
		System.out.println("합계: " + total + " 원입니다.");
		System.out.println("[p]이전 , [q]결제 완료");
		System.out.print("선택 : ");
		String sel = scan.next();
		
		switch(sel) {
		case "q":
			System.out.println("## 결제가 완료되었습니다. 종료합니다. ##");
			System.exit(0);
			break;
		case "p" :
			GameList();
			break;
		default:
			charge();
		}
	}
	
	public void genUser() {
		User user = new User("다이아", PayType.BP);
		users[0] = user;
		user = new User("챌린저", PayType.IP);
		users[1] = user;
		user = new User("브론즈", PayType.IP);
		users[2] = user;
		}
	
	public void genGame() {
		LOL cp = new LOL("그라가스", 4800, "정글러");
		games[0] = cp;
		cp = new LOL("야스오", 6300, "미드 라이너");
		games[1] = cp;
		LOL st = new LOL("이블린", 4800, "암살자");
		games[2] = st;
		st = new LOL("케이틀린", 6300, "원거리 딜러");
		games[3] = st;
	}
}