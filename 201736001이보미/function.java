package library;

import java.util.ArrayList;
import java.util.Scanner;

public class function {
	private ArrayList<Book> booklist;
	private Scanner scan;
	
	public function() {
		booklist = new ArrayList<Book>();
		scan = new Scanner(System.in);
	}
	
	public void addBook() {
		
		System.out.print("추가할 도서의 종류>> [1.SF] [2.ItBook] [3.Novel]");
		int n = scan.nextInt();
		scan.nextLine();
		
		if(n == 1)
			booklist.add(new ScienceFiction());
		else if(n == 2)
			booklist.add(new ItBook());
		else if(n == 3)
			booklist.add(new Novel());
		else {
			System.out.println("잘못 입력하셨습니다.");
			return;
	}
		System.out.print("ID 입력 >>");
		  String s = scan.nextLine();

		  if (findId(s)) {
		   System.out.println("중복된 ID가 있습니다. 처음부터 다시 시작합니다.");
		   booklist.remove(booklist.size() - 1);
		   return;
		  }
		  
		  booklist.get(booklist.size() - 1).setBookid(s);
		  
		  System.out.println("제목을 입력하세요");
		  s = scan.nextLine();
		  booklist.get(booklist.size() - 1).setSubject(s);
		  
		  System.out.println("저자를 입력하세요");
		  s = scan.nextLine();
		  booklist.get(booklist.size() - 1).setAuthor(s);
		  booklist.get(booklist.size() - 1).setBooking(false);
	}
	
	public void delBook() {
		  if (booklist.size() == 0) {
		   System.out.println("삭제 할 도서가 없습니다.");
		   return;
		  }
		  System.out.print("삭제할 책의 ID 를 입력하세요.");
		  String s = scan.nextLine();
		  int idx = findListIndex(s);
		  if (idx == -1)
		   System.out.println("ID가 잘못되었습니다.");
		  else {
		   booklist.remove(idx);
		   System.out.println(s + "도서가 삭제되었습니다.");
		  }

		}
	public void searchBook() {
		  System.out.println("도서를 조회합니다.");
		  for (Book i : booklist) {
		   System.out.print("ID : " + i.getBookid());
		   System.out.print("\t제목 : " + i.getSubject());
		   System.out.print("\t저자 : " + i.getAuthor());
		   System.out.println("\t대여여부 : " + (i.isBooking() ? "대여불가" : "대여가능"));
		  }
		}

		 public void bookingBook() {
		  System.out.print("대여할 책의 ID 를 입력하세요.");
		  String s = scan.nextLine();
		  int idx = findListIndex(s);
		  if (idx == -1)
		   System.out.println("등록되지 않은 ID 입니다.");
		  else {
		   if (booklist.get(idx).isBooking())
		    System.out.println("대여중입니다. 다음에 이용하세요.");
		   else {
		    System.out.println("대여 가능합니다. 이용해 주셔서 감사합니다.");
		    booklist.get(idx).setBooking(true);
		   }
		  }
		 }

		 public void returnBook() {
		  System.out.print("반납할 책의 ID 를 입력하세요.");
		  String s = scan.nextLine();
		  int idx = findListIndex(s);
		  if (idx == -1)
		   System.out.println("등록되지 않은 ID 입니다.");
		  else {
		   if (booklist.get(idx).isBooking()) {
		    System.out.println("이용해 주셔서 갑사합니다.");
		    System.out.println("7일간 대여료는 " + booklist.get(idx).Late(7) + "입니다.");
		    booklist.get(idx).setBooking(false);
		   } else
		    System.out.println("대여중인 도서가 아닙니다.");
		  }
		 }

		 public int findListIndex(String id) {
		  for (int i = 0; i < booklist.size(); i++) {
		   if (booklist.get(i).equals(id))
		    return i;
		  }
		  return -1;

		 }

		 public boolean findId(String id) {
		  for (int i = 0; i < booklist.size() - 1; i++) {
		   if (booklist.get(i).equals(id))
		    return true;
		  }
		  return false;

	}
}

