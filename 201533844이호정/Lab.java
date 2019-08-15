package javapj;

public class Lab extends Room { //실습용 강의실 클래스
	int computer;

	public Lab(String rname, int rnumber, int computer) {
		this.rname = rname;
		this.rnumber = rnumber;
		this.computer = computer;
	}

	@Override
	public void printExtra() { // 실습용강의실은 추가로 컴퓨터 갯수 출력
		System.out.println("실습용 컴퓨터 갯수: " + computer);
	}

}
