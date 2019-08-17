package test1_1;

public class SugangLauncher {

	public static void main(String[] args) {
		ISugang sugang= new Sugang();
		sugang.setTitle("GachonUniversity");
		sugang.genProduct();
		sugang.start();
	}

}
