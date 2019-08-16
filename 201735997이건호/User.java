package Ballers;

public class User {
	//User 감독 클래스 
	private String name,id;
	//감독 이름과 id 
	
	public User(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}