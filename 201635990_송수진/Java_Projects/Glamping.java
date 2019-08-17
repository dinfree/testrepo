package dogcamper;

public class Glamping extends CampSite {

	public Glamping(String campName, DogType validDog, int validCamp) {
		this.campName = campName;
		this.validDog = validDog;
		this.validCamp = validCamp;
		this.filename = campName;
		record();
	}

	@Override
	public void printCampDetail() {
		System.out.printf("\n\t 예약가능 캠핑싸이트: %d개"+" 캠핑유형 : 글램핑\n",validCamp);
	}
}
