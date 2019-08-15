package javabasic.black2;

import java.util.ArrayList;
import java.util.List;

public class Character extends CharInfo {
	
	 //CharInfo의 멤버변수들을 상속받았다.
	 //itemBox는 ArrayList이므로, 
	//item사용시에는 .remove()를, 
	//item현황보기는 itemBox를,
	//item습득시에는 .add()같은 ArrayList 관련 함수들로 구현했다. 
	 String name="";
	 int hp=0;
	 int strong=0;
	 int exp=0;
	 int itemCounter=0;
	 List<String> itemBox = new ArrayList();
	 
	public int getItemCounter() {
		return itemCounter;
	}

	public void setItemCounter(int itemcount) {
		itemCounter += itemcount;
	}

	public void setItemBox(List<String> itemBox) {
		this.itemBox = itemBox;
	}

	public List<String> getItemBox() {
		return itemBox;
	}
	
	public void removeItemBox() {
		itemBox.remove(0);
	}
	
	public void setItemBox(String item) {
		itemBox.add(item);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getStrong() {
		return strong;
	}
	public void setStrong(int strong) {
		this.strong = strong;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
}
