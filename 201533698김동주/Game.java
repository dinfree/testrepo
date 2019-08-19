package javastudy.game;

public abstract class Game {
	String gname;
	int price;
	
	public void printDetail() {
		System.out.print("게임명 : " + gname + ", ");
		System.out.print("가격 : " + price + " , ");
		printExtra();
	}

	public abstract void printExtra();
}
