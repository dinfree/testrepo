package javabasic.library;

public class Book {
	private String title; // 도서명
	private int code; // 도서 코드
	private String author; // 저자
	private Classification classif; // 도서 분류
	private Boolean availability=true; // 대여 가능 여부, true:대여 가능
	
	public Book() {
		
	}
	public Book(String title, int code, String author,Classification classif) {
		this.title=title;
		this.code=code;
		this.author=author;
		this.classif=classif;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Classification getClassif() {
		return classif;
	}
	public void setClassif(Classification classif) {
		this.classif = classif;
	}
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
	
}
