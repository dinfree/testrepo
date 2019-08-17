package JavaProject;

import java.util.ArrayList;

public class Store {
	String name; // 가게이름 변수
	ArrayList<menu> me = new ArrayList<menu>(); // 메뉴목록 선언
	
	// Store 생성자
	public Store(String name){
		this.name = name;
	}
	
	// 메뉴 추가
	public void add(String name , int price) {
		this.me.add(new menu(name,price));
	}
	
	// 메뉴 반환
	public ArrayList<menu> getmenu(){
		return this.me;
	}
}

