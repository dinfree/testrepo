package Project;

public class ShopLauncher {

	public static void main(String[] args) {
		IYupDduck shop = new Shop();
		shop.genProduct();
		shop.genToping();
		shop.start();
	}

}