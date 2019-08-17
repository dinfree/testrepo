package project;

public class ShopLauncher {
	public static void main(String[] args) {
		MyShop shop = new MyShop();
		shop.setTitle("카페");
		shop.generateProduct();
		shop.start();
	}
}