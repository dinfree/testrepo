package javabasic.week2.project;

public class User {
	String name;
	int Cno;
	
	public User(String name, int Cno) {
		this.name = name;
		this.Cno = Cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCno() {
		return Cno;
	}
	public void setCno(int Cno) {
		this.Cno = Cno;
	}
	
}
