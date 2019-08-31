package javapj;

public class RoomLauncher {
	public static void main(String[] args) { //메인실행 클래스
		IClassroom shop = new MyClassroom();
		shop.setTitle("MyClassroom");
		shop.genUser();
		shop.genRoom();
		shop.start();
	}
}