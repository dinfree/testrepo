package javastudy.game;

public class LOL extends Game {
	String champion;
	
	public LOL(String gname, int price, String champion) {
		this.gname = gname;
		this.price = price;
		this.champion = champion;
	}

	@Override
	public void printExtra() {
		System.out.println("챔피언: " + champion);
	}
}
