package MyGame;

public class Magicion extends CharacterJob {
	
	public Magicion(){
		characterJob("마법사");
		STR = 8;
		DEX = 8;
		INT = 20;
		LUX = 10;
	}
	@Override
	public void characterJob(String job) {
		// TODO Auto-generated method stub
		this.job=job;

	}

}
