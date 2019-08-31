package javabasic.week2project;

public abstract class Menu {
	String name;
	int price;
	
 public void printName() {
	 System.out.printf("%s", name);
 }

	public void printMenu() {
		System.out.printf("상품명:%s, 가격:%d, ",name,price);
		printDetail();
	}
	
	public abstract void printDetail();
}
