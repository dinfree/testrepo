package Kiosk;

public class Brito {
	String meat;
	String spicyLevel;
	
	//이름, 맵기정도, 가격을 출력하는 생성자
	public Brito(String meat, String spicyLevel) {
		this.meat = meat;
		this.spicyLevel = spicyLevel;
	}
	
	public int printPrice(String meat) {
		int price;
		if(meat.equals("chicken")) {
			price = 3500;
			return price;
		}
		else if(meat.equals("meat")) {
			price = 4000;
			return price;
		}
		else if(meat.equals("mix")) {
			price = 4000;
			return price;
		}
		else {
			return 0;
		}
	}
	public void printDetail() {
		System.out.printf("상품명:%s, 가격:%s, ",meat,spicyLevel);
	}
}
