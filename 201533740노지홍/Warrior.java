package MyGame;

public class Warrior extends CharacterJob {
	
	public Warrior() {
		characterJob("전사");
		STR = 20;
		DEX = 10;
		INT = 8;
		LUX = 8;
	}
	@Override
	public void characterJob(String job) {
		// TODO Auto-generated method stub
		this.job=job;

	}

}
