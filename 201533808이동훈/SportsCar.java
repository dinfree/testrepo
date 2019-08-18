package Project;

public class SportsCar extends Car{
	String power;
	
	public SportsCar(String cname, int price, String power) {
		this.cname = cname;
		this.price = price;
		this.power = power;
	}

	@Override
	public void printExtra() {
		System.out.println("마력: "+power);
	}
}
