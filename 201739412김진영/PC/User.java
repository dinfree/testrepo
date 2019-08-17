package PC;

public class User {
	private int buyItem;	// 주문 금액을 저장하는 변수
	private int useTime;	// 사용 시간을 저장하는 변수
	private String seatNum;	// 자리 번호를 저장하는 변수
	
	public User() {
		buyItem=0;
		useTime=0;
		seatNum="0";
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public int getBuyItem() {
		return buyItem;
	}
	public void setBuyItem(int buyItem) {
		this.buyItem += buyItem;
	}
	public int getUseTime() {
		return useTime;
	}
	public void setUseTime(int useTime) {
		this.useTime += useTime;
	}
}
