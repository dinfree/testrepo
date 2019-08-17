package StudyRoom;

public class Drink extends Item{	// 음료상품을 설정하는 클래스
	String remarks;
	public Drink() {}
	public Drink(String name, int price, String remarks, ItemType type) {
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
		type = ItemType.DRINK;
		return type;
	}
}
