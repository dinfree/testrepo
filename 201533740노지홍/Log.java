package MyGame;

public class Log extends CharacterJob {
	
	public Log() {
		characterJob("도적");
		STR = 8;
		DEX = 10;
		INT = 8;
		LUX = 20;
	}
	@Override
	public void characterJob(String job) {
		// TODO Auto-generated method stub
		this.job=job;

	}

}
