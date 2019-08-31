package dogcamper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DogCamper implements IDogCamper {
	//사용자 배열
	Camper[] campers = new Camper[3];
	
	//캠핑장소 배열
	CampSite[] campingSites = new CampSite[5];
	
	//예약리스트
	ArrayList<CampSite> booking = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	//로그인용 인덱스
	int selCamper;
	
	/*
	 * 사용자 생성
	 */
	@Override
	public void genCamper() {
		Camper nc = new Camper("김배추",DogType.대형견);
		campers[0] = nc;
		nc = new Camper("박양파",DogType.중형견);
		campers[1] = nc;
		nc = new Camper("이마늘",DogType.소형견);
		campers[2] = nc;
		
	}
	
	//캠핑장 생성
	@Override
	public void genCampSite() {
		Glamping gs = new Glamping("골드펫리조트",DogType.대형견,5);
		campingSites[0] = gs;
		AutoCamping as = new AutoCamping("개똥이네 캠핑장",DogType.대형견,2);
		campingSites[1] = as;
		gs = new Glamping("메이하우스",DogType.소형견,1);
		campingSites[2] = gs;
		as = new AutoCamping("도그파크랜드",DogType.중형견,3);
		campingSites[3] = as;
		GroundCamping grs = new GroundCamping("쉐르빌",DogType.소형견,0);
		campingSites[4] = grs;

	}
	
	/*
	 * 프로그램시작 메서드
	 */
	@Override
	public void start() throws IOException {
		System.out.println("##=============== Welcom to DogCamper ================##");
		System.out.println("메인화면 - 계정 선택 ");
		System.out.println("----------------");
		int i=0;
		
		for(Camper c : campers) {
			System.out.printf("[%d]%s(%s)\n",i++,c.getName(),c.getDogType());
		}
		
		System.out.println("[x]종 료");
		System.out.print("선택 : ");
		String sel = scan.next();
		
		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "x": 
				System.out.println("##[종료]선택 ##");
				System.out.println("DogCamper를 종료합니다.");
			System.exit(0);break;
			default:
				//로그인
				selCamper = Integer.parseInt(sel);
				System.out.println("\n["+campers[selCamper].getName()+"]"+"님 환영합니다\n");
				campList();
		}
	}
	
	/*
	 * 등록된 캠핑지 출력 및 찜하기
	 */
	public void campList() throws IOException {
		System.out.println("캠핑장소목록 - 캠핑지 선택");
		System.out.println("=========================");
		int i=0;
		
		// 등록된 상품 정보 출력
		for(CampSite cs : campingSites) {
			System.out.print("["+i+"]");
			cs.printDetail();
			i++;
		}
		System.out.println("[h]메인화면");
		System.out.println("[b]찜하기");
		System.out.println("[c]찜목록 비우기");
		System.out.print("선택 : ");
		String sel = scan.next();

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "h":System.out.println("##["+sel+"]##\n메인화면으로 이동합니다.");
				start();break;
			case "b":System.out.println("##["+sel+"]##\n캠핑장을 찜했습니다.\n");
				book();break;
			case "c":System.out.println("##["+sel+"]##\n찜목록을 비웠습니다.\n");
				booking.clear();
				campList();break;
			default:
				int psel = Integer.parseInt(sel);
				booking.add(campingSites[psel]);
				System.out.println("["+campingSites[psel].campName+"] 선택\n");
				campList();
		}
	}

	
	/*
	 * 예약확정을 위한 메서드
	 */
	@Override
	public void book() throws IOException {
		System.out.println("##예약 확정 하기##");
		System.out.println("=========================");
		int i=0;
		
		if(booking.isEmpty()) {
			System.out.println("****찜한 캠핑장이 없습니다. 캠핑장을 선택해 주세요!****\n\n");
			campList();
		}else {
	
		// 장바구니에 등록된 상품 정보 출력
		for(CampSite bcs : booking) {
			System.out.printf("[%d]%s(%s)\n",i++,bcs.campName,bcs.validDog);
		}
		System.out.println("=========================");
		

		System.out.println("상기의 캠핑장을 예약하시겠습니까? 예약 후 취소는 불가합니다.");
		System.out.println("[p]이전 , [q]예약하기");
		System.out.print("선택 : ");
		String sel = scan.next();

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "q":
				for(CampSite bcs : booking) {
					DogType validDog = bcs.validDog;
					DogType campersDog = campers[selCamper].getDogType();
					String filename = "D:/workspace_for_eclipse/javaBasic/src/dogcamper/"+bcs.campName+"_Booking_List.txt";
					FileWriter fw = new FileWriter(filename,true);
					
					switch(validDog) {	
						case 대형견: bcs.countRoom();
									fw.write("\r\n["+campers[selCamper].getName()+"]   <"+campers[selCamper].getDogType()+
											">   예약완료");break;
											
						case 중형견: if(campersDog == DogType.대형견) {
							System.out.println(bcs.campName+"의 반려견 허용범위를 넘어 예약이 불가합니다.");
						}else {bcs.countRoom();
							fw.write("\r\n["+campers[selCamper].getName()+"]   <"+campers[selCamper].getDogType()+
							">   예약완료");}break;
								
						case 소형견: if(campersDog == DogType.소형견) {
							bcs.countRoom();
							fw.write("\r\n["+campers[selCamper].getName()+"]   <"+campers[selCamper].getDogType()+
									">   예약완료");
						}else System.out.println(bcs.campName+"의 반려견 허용범위를 넘어 예약이 불가합니다.");
						break;
					}
				fw.close();	
				}

					System.out.println("## 예약이 완료 되었습니다.종료합니다 ##");
					System.exit(0);break;
			case "p":campList();break;
			default: book();
		}
		}		

	}
}
