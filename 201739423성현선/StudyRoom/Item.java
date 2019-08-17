package StudyRoom;

public abstract class Item {	// 상품의 슈퍼클래스
	String name;
	int price;
	ItemType type;
	
	public void showItem() {
		printClass();
		System.out.printf("상품명 : "+name);
		System.out.print("(");
		System.out.printf("%s",printItemType());
		System.out.print(")");
		System.out.print("\n");
		System.out.println("가격 : "+price);


		printRemarks();
	}
	
	public abstract void printClass();
	public abstract void printRemarks();
	public abstract ItemType printItemType();
}
