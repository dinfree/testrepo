package JavaProject;

import java.util.ArrayList;

public class StoreList {
	ArrayList<Store> sl = new ArrayList<Store>(); // Store 선언
	
	// Store 생성
	public StoreList() {
		sl.add(new Store("중국집"));
		sl.get(0).add("짜장면", 4000);
		sl.get(0).add("짬뽕", 5500);
		sl.get(0).add("새우볶음밥", 6000);
		sl.get(0).add("탕수육", 13000);
				
		sl.add(new Store("한식"));
		sl.get(1).add("김밥", 2500);
		sl.get(1).add("된장찌개", 5500);
		sl.get(1).add("김치찌개", 5500);
		
		sl.add(new Store("일식"));
		sl.get(2).add("돈까스", 7000);
		sl.get(2).add("생선까스", 7500);
		sl.get(2).add("치즈돈까스", 7500);
		sl.get(2).add("우동", 3500);
		
		sl.add(new Store("치킨"));
		sl.get(3).add("후라이드치킨", 15000);
		sl.get(3).add("양념치킨", 16000);
		sl.get(3).add("간장치킨", 16000);
		sl.get(3).add("오리엔탈파닭", 16000);
	}
	
	
	public ArrayList<Store> getstorelist(){
		return this.sl;
	}
	
}
