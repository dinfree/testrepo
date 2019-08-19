package locker;

import locker.Available;

public class LockerNumber {
	private String num;
	private Available avail;
	
	public LockerNumber(String num, Available avail) {
		this.num = num;
		this.avail = avail;
	}

	public String getName() {
		return num;
	}

	public void setName(String num) {
		this.num = num;
	}

	public Available getPayType() {
		return avail;
	}

	public void setPayType(Available avail) {
		this.avail = avail;
	}
}
