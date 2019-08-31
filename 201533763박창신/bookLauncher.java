package javabasic.week2.project;

public class bookLauncher {

	public static void main(String[] args) {
		Library lib = new MyLibrary();
		lib.setTitle("[MyLib]");
		lib.genUser();
		lib.genBook();
		lib.start();
		
	}
}