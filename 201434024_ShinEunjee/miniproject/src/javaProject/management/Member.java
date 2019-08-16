package javaProject.management;

public class Member {
	private String name;
	private int age;
	private String job;
	private int period;
//	private int seatNo;
	private int status = 0;
	
	public Member() {
		
	}
	
	public Member(String name, int age, String job, int period) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.period = period;
	}

	public void checkin() {
		
	}
	
	public void checkout() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
