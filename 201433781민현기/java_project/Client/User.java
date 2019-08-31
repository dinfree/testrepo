package Client;


public class User {
	private String name;
	private UserType userType;
	private int money;
	private int hp;

	public int getMoney() {
		return money;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	User(String name, int money, UserType userType)
	{
		this.name=name;
		this.money=money;
		this.userType=userType;

		switch(userType){
			case HEALER:
				this.hp=150;
				break;
			case DEALER:
				this.hp=100;
				break;
			case TANKER:
				this.hp=200;
				break;
		}
	}

	public String getName() {
		return name;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showStatus(){
		System.out.println(name+"님의 현재 상태");
		System.out.println("HP: "+hp);
		System.out.println("골드: "+money);
	}


	
}
