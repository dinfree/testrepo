package javabasic.week2project;

public class Kiosk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IShop shop = new MyShop();
		shop.genBurger();
		shop.genSide();
		shop.genDrink();
		shop.start();
		
	}

}
