package javabasic.train;

public class User {
	private UserType usertype;
	
	public User(UserType usertype) {
		this.usertype = usertype;
	}
	
	public UserType getUsertype() {
		return usertype;
	}
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}
}
