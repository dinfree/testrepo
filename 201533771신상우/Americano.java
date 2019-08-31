package javabasic.project;

public class Americano extends Beverage {
	String bean;

	public Americano(String bname, int price, String bean) {
		this.bname = bname;
		this.price = price;
		this.bean = bean;
	}
	@Override
	public void printExtra() {
		System.out.println(" 원두: "+bean);

	}
}
