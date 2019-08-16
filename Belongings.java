package locker;

public abstract class Belongings {
	String oname;
	
	public void printDetail() {
		System.out.printf("소지품 이름: %s\n",oname);
	}

}
