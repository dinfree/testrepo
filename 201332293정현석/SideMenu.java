package javabasic.week2project;

public class SideMenu extends Menu {
	int addCost;
	
	public SideMenu(String name, int addCost) {
		this.name=name;
		this.addCost=addCost;
	}
	
	public void printDetail()
	{
		System.out.println("(+"+addCost+")");
	}

}
