package PC;

public class DrinkItem extends Item{	// [음료] 상품을 설정하는 클래스
	String remarks;
	public DrinkItem() {}
	public DrinkItem(String name, int price, String remarks) {
		this.name = name;
		this.price = price;
		this.remarks = remarks;
	}
	@Override
	public void printClass() {
		System.out.println("** DRINK ***************************");
	}

	@Override
	public void printRemarks() {
		System.out.println("비고 : (음료)"+remarks);
		System.out.println("************************************");
	}

}
