package Client;



public class GameLauncher {

	public static void main(String[] args) {

		pGame shop = new MyGame();
		shop.setTitle("MyGame");
		shop.genUser();
		shop.genProduct();
		shop.start();
	}

			}
