package dogcamper;

import java.io.BufferedWriter;
import java.io.FileWriter;

public abstract class CampSite {
	String campName;
	DogType validDog;
	int validCamp;
	String filename;
	
	public void printDetail() {
		System.out.printf("%s[%s 허용]",campName,validDog);
		printCampDetail();
	}
	public abstract void printCampDetail();
	
	public boolean countRoom() {
		if(validCamp!=0) {
			--this.validCamp;
			System.out.printf("%s의 예약이 완료되었습니다!\n",this.campName);
			return true;
		}else {
			System.out.printf("%s의 예약가능한 캠프싸이트가 모두 소진되어 예약이 불가합니다.\n",this.campName);
			return false;
		}
	}
	public void record() {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("D:/workspace_for_eclipse/javaBasic/src/dogcamper/"+filename+"_Booking_List.txt"));
				String header;
				header = "-----------------------------------\r\n###"
						+ this.campName+" 예약 리스트###\r\n"+
						"-----------------------------------\n";
				writer.write(header);
				writer.close();
		}catch(Exception e) {
			e.printStackTrace();
	}
}
