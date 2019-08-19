package project;

public class Product {

	// 상품명과 가격 변수
	String name;
	int price;

	// 상품 생성자
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// 상품명과 가격을 출력하는 기본정보 출력 메서드
	public void print() {
		System.out.printf("[제품명] %s\t[가격] %d", name, price);
	}
}