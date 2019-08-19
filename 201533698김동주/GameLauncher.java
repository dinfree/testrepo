package javastudy.game;

public class GameLauncher {
	public static void main(String[] args) {
		GameMarket shop = new MyGame();
		shop.genUser();
		shop.genGame();
		shop.start();
	}
}
