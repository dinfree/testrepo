package Project;

public class YupDduck extends Product {
	String taste;
	
	public YupDduck(String yname, int price, String taste) {
		this.yname = yname;
		this.price = price;
		this.taste = taste;
	}
	
	public void printExtra() {
		System.out.println("맛 : " + taste);
	}
}
