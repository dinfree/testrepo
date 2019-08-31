package javabasic.week2project;

public class Burger extends Menu{
	
	int addCost=price+2000;
	
	public Burger(String name, int price) {
		this.name=name;
		this.price=price;
	}	
	
	public void printDetail() {
		System.out.println("세트 : (+"+addCost+")");
	}
}

