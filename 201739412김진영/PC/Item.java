package PC;

public abstract class Item {	// 상품을 위한 슈퍼클래스
	String name;
	int price;
	
	public void showItem() {
		printClass();
		System.out.println("상품명 : "+name);
		System.out.println("가격 : "+price);
		printRemarks();
	}
	
	public abstract void printClass();
	public abstract void printRemarks();
}
