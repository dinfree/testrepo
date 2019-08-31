package Ballers;

//선수 클래스
public class Player {
	private String name,backnum;
	
	public String getBacknum() {
		return backnum;
	}

	public void setBacknum(String backnum) {
		this.backnum = backnum;
	}

	private Team team;
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
