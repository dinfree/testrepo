package Project;

public abstract class Product {
	String yname;
	int price;
	
	public void printDetail() {
		System.out.printf("상품명 : %s  | 가격 : %d  | ", yname, price);
		printExtra();
	}
	
	public abstract void printExtra();
}
