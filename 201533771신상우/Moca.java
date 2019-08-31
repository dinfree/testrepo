package javabasic.project;

public class Moca extends Beverage {
	String choco;
	boolean whip;

	public Moca() {}
	
	public Moca(String bname, int price, String choco, boolean whip) {
		this.bname = bname;
		this.price = price;
		this.choco = choco;
		this.whip = whip;
	}
	@Override
	public void printExtra() {
		System.out.println(" 초코: "+choco +"  휘핑 크림: " + whip);

	}

}
