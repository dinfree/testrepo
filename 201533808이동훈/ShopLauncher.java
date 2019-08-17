package Project;

public class ShopLauncher {

	public static void main(String[] args) {
		IShop shop = new MyCar();
		shop.setTitle("MyCar");
		shop.genUser();
		shop.genCar();
		shop.start();
	}

}
