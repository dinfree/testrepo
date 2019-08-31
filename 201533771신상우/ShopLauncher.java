package javabasic.project;

public class ShopLauncher {

	public static void main(String[] args) {
		IShop shop = new MyCafe();
		shop.setTitle("MyCafe");
		shop.genProduct();
		shop.start();

	}

}
