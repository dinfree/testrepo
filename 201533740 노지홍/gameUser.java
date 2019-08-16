package MyGame;

public class gameUser {
	String username;
	String password;
	
	public gameUser(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String userGetName() {
		return username;	
	}

}
