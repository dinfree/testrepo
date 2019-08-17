package Project;

public abstract class Car {
	
	String cname;
	int price;
	
	public void printDetail() {
		System.out.printf("상품명:%s, 가격:%d, ",cname,price);
		printExtra();
	}
	
	public abstract void printExtra();
}
