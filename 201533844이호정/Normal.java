package javapj;

public class Normal extends Room { // 일반강의실 클래스
	int table;

	public Normal(String rname, int rnumber, int table) {
		this.rname = rname;
		this.rnumber = rnumber;
		this.table = table;
	}

	@Override
	public void printExtra() { //일반강의실은 책상갯수 출력
		System.out.println("책상 갯수: " + table);
	}

}
