package dogcamper;

public class Camper {
	private String name;
	private DogType dogType;
	
	public Camper(String name, DogType dogType) {
		this.name=name;
		this.dogType = dogType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DogType getDogType() {
		return dogType;
	}

	public void setDogType(DogType dogType) {
		this.dogType = dogType;
	}
	
}
