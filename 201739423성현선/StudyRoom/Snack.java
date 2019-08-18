package StudyRoom;

public class Snack extends Item{	// [과자류] 상품을 설정하는 클래스
	String remarks;
	public Snack() {}
	public Snack(String name, int price, String remarks, ItemType type) {
		this.name = name;
		this.price = price;
		this.remarks = remarks;
		this.type = type;
	}
	@Override
	public void printClass() {
		System.out.println("───────────────────────────────────────────────────");
	}

	@Override
	public void printRemarks() {
		System.out.println("비고 : "+remarks);
		System.out.println("───────────────────────────────────────────────────");
	}

	public ItemType printItemType() {
		type = ItemType.SNACK;
		return type;
	}
}
