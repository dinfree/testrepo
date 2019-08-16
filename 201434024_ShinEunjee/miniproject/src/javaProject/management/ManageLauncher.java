package javaProject.management;

public class ManageLauncher {

	public static void main(String[] args) {
		IManage manager= new Manager();
		manager.setTitle("가천독서실");
		manager.defaultSet();
		manager.start();
	}
}
