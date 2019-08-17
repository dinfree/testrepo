package dogcamper;

import java.io.IOException;

public class DogCamperLauncher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		IDogCamper idc = new DogCamper();
		idc.genCamper();
		idc.genCampSite();
		idc.start();
		
	}

}
