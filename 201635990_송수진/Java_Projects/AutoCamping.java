package dogcamper;

public class AutoCamping extends CampSite {
	
	public AutoCamping(String campName, DogType validDog, int validCamp) {
		this.campName = campName;
		this.validDog = validDog;
		this.validCamp = validCamp;
		this.filename = campName;
		record();
	}

	@Override
	public void printCampDetail() {
		// TODO Auto-generated method stub
		System.out.printf("\n\t 예약가능 캠핑싸이트: %d개"+" 캠핑유형 : 오토캠핑\n",validCamp);

	}

}
