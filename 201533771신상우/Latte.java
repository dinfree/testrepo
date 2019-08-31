package javabasic.project;

public class Latte extends Beverage {
	String favor;
	
	public Latte(String bname, int price, String favor) {
		this.bname = bname;
		this.price = price;
		this.favor = favor;
	}
	@Override
	public void printExtra() {
		System.out.println(" 맛: "+favor);

	}
}
