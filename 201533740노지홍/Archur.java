package MyGame;

public class Archur extends CharacterJob {
	
	public Archur() {
		characterJob("궁수");
		STR = 10;
		DEX = 20;
		INT = 8;
		LUX = 8;	
	}
	@Override
	public void characterJob(String job) {
		// TODO Auto-generated method stub
		this.job = job;

	}

}
