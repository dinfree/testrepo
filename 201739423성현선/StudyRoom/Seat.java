package StudyRoom;

import java.util.ArrayList;
import java.util.Scanner;


public class Seat {		// 자리를 설정하는 클래스
	ArrayList<User> userlist = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	User userTemp = new User();

	public Seat() {		// 자리를 초기화하는 생성자
		int num;
		
		for(int i=0; i<25; i++) {
			User user = new User();
			num = i+1;
			user.setSeatNum(Integer.toString(num));
			userlist.add(i, user);
		}
	}
	
	public void infoSeat() {	// 자리 목록을 보여주는 메소드
		System.out.println("── 자리 목록 ──────────────────────────────────────────\n");
		int index = 1;
		for(User s : userlist) {
			System.out.print("\t"+s.getSeatNum());
			if(index%5 == 0) {
				System.out.print("\n");
			}
			index++;
		}
		System.out.println("\n───────────────────────────────────────────────────");
	}
	
	public void infoSelect() {
		System.out.println("[s] 자리 선택, [b] 이전 ");
		System.out.print("선택 >> ");
		String i = scan.next();
		
		switch(i) {
			case "s":
				selectSeat();	// 자리 선택을 위한 함수 불러오기
				break;
			case "b":
				Launcher.start();
				break;
			default :
				System.out.println("※ 잘못 입력 하셨습니다. s 또는 b 를 입력해 주세요! ※");
				System.out.println("\n");
				infoSeat();
				infoSelect();
				break;
		}
	}
	
	public void selectSeat() {	// 자리를 선택하기 위한 메서드
		System.out.print("사용할 자리 번호를 선택하세요( x : 사용중 ) >> ");
		int select = scan.nextInt();
		int index = select-1;
		
		userTemp = userlist.get(index);
		if(userTemp.getSeatNum()=="x") {
			System.out.println("※ 이미 사용중인 자리입니다. 다른 자리를 이용하세요 ※");
			selectSeat();
		}
		else {
			userTemp.setSeatNum("x");
			inputTime(select);
		}
	
	}
	
	public void inputTime(int select) {	// 사용 시간을 입력받는 메서드
		int index = (select - 1);
		System.out.print("이용 시간을 숫자로 입력하세요(시간당 1,000원) >> ");
		int t = scan.nextInt();
		
		
		userTemp.setUseTime(t);
		userlist.set(index, userTemp);
		System.out.print("\n");
		System.out.println("***************************************************");		
		System.out.println(select + "번 자리에 " + t +"시간 사용 등록이 완료되었습니다.");
		System.out.println("***************************************************");
		System.out.print("\n");

		Launcher.start();
		
	}

}
