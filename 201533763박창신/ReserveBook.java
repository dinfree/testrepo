package javabasic.week2.project;

public class ReserveBook extends Book {
	Reserved reserve;
	
	public ReserveBook(String bname, int bno, String genre, Reserved reserve) {
		this.bname = bname;
		this.bno = bno;
		this.genre = genre;
		this.reserve = reserve;
		}
	@Override
	public void printExtra() {
		System.out.println(bname + " [예약상태] : " + reserve);
	}

}
