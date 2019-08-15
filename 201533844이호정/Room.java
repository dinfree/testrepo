package javapj;

public abstract class Room {// 강의실 추상클래스
	String rname;
	int rnumber;

	public void printDetail() { 
		System.out.print("강의실 이름: " + rname + " , ");
		System.out.print("강의실 인원: " + rnumber + " , ");
		printExtra();
	}

	public abstract void printExtra();
}
