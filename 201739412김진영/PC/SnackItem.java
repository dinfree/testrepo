package PC;

public class SnackItem extends Item{	// [과자류] 상품을 설정하는 클래스
	String remarks;
	public SnackItem() {}
	public SnackItem(String name, int price, String remarks) {
		this.name = name;
		this.price = price;
		this.remarks = remarks;
	}
	@Override
	public void printClass() {
		System.out.println("** SNACK ***************************");
	}

	@Override
	public void printRemarks() {
		System.out.println("비고 : (과자류)"+remarks);
		System.out.println("************************************");
	}

}
