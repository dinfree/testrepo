package library;

import java.util.Scanner;

public class LibrarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		function f = new function();
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("[1.도서추가] [2.도서삭제] [3.도서조회] [4.도서대여] [5.도서반납] [6.종료]");
			System.out.println("-----------------------------------------------------------");
			System.out.print("선택 : ");
			
			int select = scan.nextInt();
			scan.hasNextLine();
			 if (select == 1)
				    f.addBook();
				   else if (select == 2)
				    f.delBook();
				   else if (select == 3)
				    f.searchBook();
				   else if (select == 4)
				    f.bookingBook();
				   else if (select == 5)
				    f.returnBook();
				   else if (select == 6)
				    run = false;
		}
		System.out.println("프로그램을 종료합니다.");
		
	}

}
