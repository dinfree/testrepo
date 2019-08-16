package javabasic.project;

public abstract class Beverage {
	// 상품명과 가격 변수
		String bname;
		int price;
		String type;
		
		// 상품명과 가격을 출력하는 기본정보 출력 메서드
		public void printDetail() {
			System.out.printf("음료: %s, 가격: %d ",bname, price);
			printExtra();
		}
		
		public abstract void printExtra();
}
