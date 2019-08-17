package shoppingmall;

public class Used extends Product {
//중고 제품 클래스
	Integer period;
	String as;

	public Used(String pname, int price, Integer period, String as) {
		this.pname = pname;
		this.price = price;
		this.period = period;
		this.as = as;
	}

	@Override
	public void printDetail() {
		System.out.println("상품 이름 : " + pname + ", 상품 가격 : " + price + ", 중고 여부 : 중고, 사용 기간 : " + period + ", AS 가능 여부 : " + as);
	}

	@Override
	public String returnString() {
		String temp;
		temp = "상품 이름 : " + pname + ", 상품 가격 : " + price + ", 중고 여부 : 중고, 사용 기간 : " + period + ", AS 가능 여부 : " + as;
		return  temp;
	}
}
