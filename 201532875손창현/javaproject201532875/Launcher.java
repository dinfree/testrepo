package javaproject201532875;

import java.util.Scanner;

public class Launcher {
	      
	// 메뉴출력 메서드
	public static void printMenu() {     
		System.out.println("          ** 대학교 학적 관리 프로그램  **\n");
		System.out.println("  [대학 목록]");
		System.out.println("(1) 가천대학교");
		System.out.println("(x) 종료");
		System.out.print("입력 ==> ");
	}
	
	public static void main(String[] args) {          
		Scanner scan = new Scanner(System.in);
		String select;
		
		printMenu();
		select = scan.next();
		System.out.println("\n");
		while(true) {
			switch(select) {
				case "1":
					UniversityInterface univ = new University();
					univ.setTitle("가천대학교");
					univ.launch();
					break;
				case "x":
					System.out.println("프로그램 종료...");
					System.exit(0);
				default:
					System.out.println("잘못 입력하셨습니다. 프로그램 종료...");
					System.exit(0);
			}
			scan.close();
		}
	}
}
