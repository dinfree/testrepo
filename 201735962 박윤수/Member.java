package cafe;

public class Member {
	private int phon_num;
	private int point;
	private int purchaseAmount;
	private Grade m_garde;
	
	
	public Member(int phon_num, int point, int purchaseAmount, Grade m_garde) {
		super();
		this.phon_num = phon_num;
		this.point = point;
		this.purchaseAmount = purchaseAmount;
		this.m_garde = m_garde;
	}
	public int getPhon_num() {
		return phon_num;
	}
	public void setPhon_num(int phon_num) {
		this.phon_num = phon_num;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public Grade getM_garde() {
		return m_garde;
	}
	public void setM_garde(Grade m_garde) {
		this.m_garde = m_garde;
	}
	
	
	


}
