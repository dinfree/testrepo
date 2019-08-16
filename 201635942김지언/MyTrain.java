package javabasic.train;

import java.util.Scanner;

public class MyTrain extends Choose implements ITrain {
	
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void genUser() {
		User user = new User(UserType.ADULT);
		users[0] = user;
		user = new User(UserType.CHILD);
		users[1] = user;
		user = new User(UserType.SENIOR);
		users[2] = user;
	}

	@Override
	public void genSeats() {
		Seats seat = new Seats(SeatType.PREMIUM,29000);
		seats1[0] = seat;
		seat =new Seats(SeatType.STANDARD,20000);
		seats1[1] = seat;
		
		seat = new Seats(SeatType.PREMIUM,19000);
		seats2[0] = seat;
		seat =new Seats(SeatType.STANDARD,10000);
		seats2[1] = seat;
		
		seat = new Seats(SeatType.PREMIUM,24000);
		seats3[0] = seat;
		seat =new Seats(SeatType.STANDARD,15000);
		seats3[1] = seat;
	}

	@Override
	public void start() {
		System.out.println("~승객유형 선택~");
		int i=1;
		
		for(User u : users) {
				System.out.printf("[%d]%s\n",i++,u.getUsertype());
		}
		
		System.out.println("[x]종 료");
		System.out.print("선택: ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		switch(sel) {
		case "x": 
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			selUser = Integer.parseInt(sel)-1;
			next();
		}
	}
	
	public void next() {
		System.out.println("~좌석구분 선택~");
		int i=1;
		if(selUser==0) {
			for(Seats s : seats1) {
				System.out.printf("[%d]%s(%d원)\n",i++,s.getSeatType(),s.getPrice());
			}
		}else if(selUser==1) {
			for(Seats s : seats2) {
				System.out.printf("[%d]%s(%d원)\n",i++,s.getSeatType(),s.getPrice());
			}
		}else if(selUser==2) {
			for(Seats s : seats3) {
				System.out.printf("[%d]%s(%d원)\n",i++,s.getSeatType(),s.getPrice());
			}
		}
		
		System.out.println("[x]종 료");
		System.out.print("선택: ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		switch(sel) {
		case "x": 
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default:
			selSeats = Integer.parseInt(sel)-1;
			reservation();
		}
	}

}
