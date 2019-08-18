package Project;

public class Suv extends Car{
	String torque;
	
	public Suv(String cname, int price, String torque) {
		this.cname = cname;
		this.price = price;
		this.torque = torque;
	}

	@Override
	public void printExtra() {
		System.out.println("토크: "+torque);
	}
}
