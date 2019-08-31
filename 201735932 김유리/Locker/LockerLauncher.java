package locker;

public class LockerLauncher {
	public static void main(String[] args) {
		ILocker locker = new UseLocker();
		locker.setTitle("MyShop");
		locker.genUser();
		locker.genProduct();
		locker.start();
	}
}
