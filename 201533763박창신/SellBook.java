package javabasic.week2.project;

public class SellBook extends Book {
	int price;
	
	public SellBook(String bname, int bno, String genre, int price) {
		this.bname = bname;
		this.bno = bno;
		this.genre = genre;
		this.price = price;
	}
	public void printExtra() {
		System.out.println(bname+" [구매가능] 가격: "+ price);
	}

}
