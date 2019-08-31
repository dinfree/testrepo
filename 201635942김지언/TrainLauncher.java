package javabasic.train;

import java.util.Scanner;

public class TrainLauncher extends MyTrain {
	Scanner scan = new Scanner(System.in);
	
	public TrainLauncher() {
		System.out.println("## 기차 좌석 예매 프로그램 ##");
		while(true) {
			System.out.println("=====================");
			System.out.println("[1]예 약\n[2]조 회\n[3]취 소\n[x]종 료");
			System.out.print("선택: ");
			String num = scan.next();
			System.out.println("## "+num+"선택 ##");
			switch(num) {
			case "x": 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case "1":
				new MyTrain();
				genUser();
				genSeats();
				start();
				break;
			case "2":
				lookup();
				break;
			case "3":
				cancel();
				break;
			default:
				System.out.println("다시 선택해주세요.");
				continue;
			}
		}
	}
}
