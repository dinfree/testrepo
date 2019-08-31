package memo;

public class User {
	private String ID;
	private String Password;
	
	public User() {}
	
	public User(String ID, String Password) {
		this.ID = ID;
		this.Password = Password;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	

}
