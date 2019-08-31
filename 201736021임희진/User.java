package javabasic.library;

import java.util.Scanner;

public class User {
	private String name; // 사용자명
	private int id; // 사용자 id(학번)
	private int count=5; // 대출 가능 도서수 5권
	
	public User() {
		
	}
	public User(String name, int id) {
		this.name=name;
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void upCount() {
		count = count+1;
	}
	public void downCount() {
		count = count-1;
	}
}
