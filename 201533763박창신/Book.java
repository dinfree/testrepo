package javabasic.week2.project;

public abstract class Book {
	String bname;
	int bno;
	String genre;
	
	public void printDetail() {
		System.out.println("책 이름 : " + bname);
		System.out.println("도서번호 : " + bno);
		System.out.println("장르 : " + genre);
		printExtra();
	}
	public abstract void printExtra();
}
