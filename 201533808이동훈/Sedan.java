package Project;

public class Sedan extends Car{
	String fuelEfficiency;
	
	public Sedan(String cname, int price, String fuelEfficiency) {
		this.cname = cname;
		this.price = price;
		this.fuelEfficiency = fuelEfficiency;
	}

	@Override
	public void printExtra() {
		System.out.println("연비: "+fuelEfficiency);
	}
}
