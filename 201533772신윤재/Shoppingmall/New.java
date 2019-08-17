package shoppingmall;

public class New extends Product {
//신품 클래스
	public New(String pname, int price) {
		this.pname = pname;
		this.price = price;
	}

	@Override
	public String returnString() {
	    String temp;
		temp = "상품 이름 : " + pname + ", 상품 가격 : " + price + ", 중고 여부 : 신품";
		return temp;
	}

    @Override
    public void printDetail() {
        System.out.println("상품 이름 : " + pname + ", 상품 가격 : " + price + ", 중고 여부 : 신품");
    }
}
