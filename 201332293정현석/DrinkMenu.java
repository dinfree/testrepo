package javabasic.week2project;

public class DrinkMenu extends Menu{
	
	public DrinkMenu(String name) {
		this.name=name;
	}

	public void printMenu() {
		System.out.printf("상품명: %s ",name);
		printDetail();
	}

	@Override
	public void printDetail() {
		System.out.print("+0\n");
		// TODO Auto-generated method stub
		
	}
		
}
