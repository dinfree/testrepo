package test1_1;

public abstract class Subject {

	String sname, pname, day;
	int credit;

	public void printDetail() {
		System.out.printf("과목명: %s, 교수명: %s, 학점: %d, 수업 일자: %s \n",sname , pname, credit, day);
	}
}
