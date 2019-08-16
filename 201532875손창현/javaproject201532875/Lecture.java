package javaproject201532875;

public class Lecture {
	private String lectureName;
	private double score;
	private char grade;
	
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public char getGrade(){
		return grade;
	}       
	public void setGrade(){               //  학점 부여 점수  기준
		if (this.score >= 90.0)
			this.grade = 'A';
		else if (this.score >= 80.0)
			this.grade = 'B';
		else if (this.score >= 70.0)
			this.grade = 'C';
		else if (this.score >= 60.0)
			this.grade = 'D';
		else
			this.grade = 'F';
	}
}