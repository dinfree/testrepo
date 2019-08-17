package PC;

public class FoodItem extends Item{		// [식사류] 상품을 설정하는 클래스
	String remarks;
	public FoodItem() {}
	public FoodItem(String name, int price, String remarks) {
		this.name = name;
		this.price = price;
		this.remarks = remarks;
	}
	@Override
	public void printClass() {
		System.out.println("** FOOD ****************************");
	}

	@Override
	public void printRemarks() {
		System.out.println("비고 : (식사류)"+remarks);
		System.out.println("************************************");
	}

}
