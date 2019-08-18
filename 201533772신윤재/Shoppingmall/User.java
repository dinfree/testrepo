package shoppingmall;

public class User {
	private String name;
	private String pass;
	private String passQuestion;
	private String passAnswer;
	private String phone;

	public User(String name, String pass, String passQuestion, String passAnswer, String phone) {
		this.name = name;
		this.pass = pass;
		this.passQuestion = passQuestion;
		this.passAnswer = passAnswer;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassAnswer() {
		return passAnswer;
	}

	public void setPassAnswer(String passAnswer) {
		this.passAnswer = passAnswer;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPassQuestion() {
		return passQuestion;
	}

	public void setPassQuestion(String passQuestion) {
		this.passQuestion = passQuestion;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
