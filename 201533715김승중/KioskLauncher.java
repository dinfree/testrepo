package Kiosk;

public class KioskLauncher {

	public static void main(String[] args) {
		MyKiosk kiosk = new MyKiosk();
		kiosk.genProduct();
		kiosk.start();
	}

}
