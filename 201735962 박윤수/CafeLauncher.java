package cafe;

public class CafeLauncher {

	public static void main(String[] args) {
		Cafe cafe = new MyCafe();
		cafe.genMember();
		cafe.genMenu();
		cafe.open();

	}

}
