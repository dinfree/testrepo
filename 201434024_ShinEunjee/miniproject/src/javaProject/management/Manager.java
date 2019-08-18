package javaProject.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Manager implements IManage {
	//등록 회원 객체 리스트
	ArrayList<Member> userList = new ArrayList<Member>();
	Member member;
	
	//좌석번호 배열
	int[] seatNo = new int[20];

	//회원객체와 좌석번호
	HashMap<Member, Integer> userSeat = new HashMap<Member, Integer>();
	
	Scanner scan = new Scanner(System.in);
	
	int sel, inputInt;
	String inputStr;
	String title;
	
	public void setTitle(String title) {
		this.title= title;
	}
	
	@Override
	public void start() {
		System.out.println(title+" 회원 관리 프로그램 메인 화면입니다.");
		System.out.println("1. 회원 조회 | 2. 회원 등록  | 3. 좌석 조회 | 4. 종료");
		System.out.print("실행할 작업의 번호를 입력하세요: ");
		int sel = scan.nextInt();
		scan.nextLine();
		switch(sel) {
		//회원 조회
		case 1:
			System.out.println("회원 목록 출력");
			System.out.println("=============================================");
			for (Member m : userList) {
				System.out.printf("[%d] 이름: %s | 나이: %d | 직업: %s | 등록일수: %d | 좌석번호: %d"
						,userList.indexOf(m),m.getName(), m.getAge(),
						m.getJob(), m.getPeriod(), userSeat.get(m));
				System.out.println("");
			}
			System.out.println("=============================================");
			System.out.println("1. 메인화면 | 2. 회원정보 수정");
			sel= scan.nextInt();
			scan.nextLine();
			switch(sel) {
			case 2:
				editMember();
				break;
			default:
				start();
				break;
			}
			break;
		//회원 등록	
		case 2:
			genMember();
			break;
		//좌석 조회 
		case 3:
			curSeat();
			break;
		//시스템 종료
		case 4:
			System.out.println("회원 관리 프로그램을 종료합니다.");
			System.exit(0);
			break;
		default: 
			System.out.println("잘못된 번호입니다.");
			start();
		}
	}
	
	@Override
	public void defaultSet() {
		//배열에 좌석번호 부여
		for(int i=0; i<20; i++) {
		seatNo[i]= i+1;
		}
		//디폴트 멤버 생성(DB 연결 안 된 상태에서 매번 새 멤버 생성 필요 방지)
		member = new Member("김기본", 24, "취준생", 30);
		userList.add(member);
		member = new Member("신은지", 25, "학생", 14);
		userList.add(member);
		userSeat.put(userList.get(0), seatNo[6]);
		userSeat.put(userList.get(1), seatNo[0]);
	}
		
	@Override
	public void genMember() {				
		//임시 변수 추가 선언해서 이름, 나이 등 개인 정보 입력받아 생성자로 생성
		/* System.out.println("회원 이름: ");
		 * inputStr=scan.nextLine();
		 * System.out.println("회원 나이: ");
		 * inputInt=scan.nextInt();
		 * System.out.println("회원 직업: ");
		 * String inputStr2=scan.nextLine();
		 * System.out.println("등록 일수: ");
		 * int inputInt2=scan.nextInt();
		 * member = new Member(inputStr, inputInt, inputStr2, inputInt2);
		 */

		//일단 인스턴스 생성하고 setter로 입력
		member= new Member();
		System.out.println("회원 이름: ");
		inputStr=scan.nextLine();
		member.setName(inputStr);
		System.out.println("회원 나이: ");
		inputInt=scan.nextInt();
		scan.nextLine();
		member.setAge(inputInt);
		System.out.println("회원 직업: ");
		inputStr=scan.nextLine();
		member.setJob(inputStr);
		System.out.println("등록 일수: ");
		inputInt=scan.nextInt();
		scan.nextLine();
		member.setPeriod(inputInt);
		
		System.out.println("등록 완료. 좌석을 지정하세요");
		setSeat(member);
	}
	
	@Override
	public void curSeat() {
		System.out.printf("현재 등록 가능한 좌석은 %d개 입니다.\n",(20-userSeat.size()));
		System.out.println("입실 현황");
		System.out.println("=============================================");
		for(Member m: userSeat.keySet()) {
			System.out.print("좌석: "+userSeat.get(m)+" | "+m.getName()+" 회원 |");
			System.out.print("입실 상태: ");
			switch(m.getStatus()) {
			case 0:
				System.out.print("공실\n");
				break;
			case 1:
				System.out.print("입실\n");
				break;
			}
		}
		System.out.println("=============================================");
		System.out.println("1. 메인 화면 | 2. 좌석 변경");
		sel=scan.nextInt();
		scan.nextLine();
		switch(sel) {
		case 1:
			start();
			break;
		case 2:
			System.out.println("변경할 좌석번호를 선택하세요: ");
			inputInt=scan.nextInt();
			scan.nextLine();
			while(!userSeat.containsValue(inputInt)) {
				System.out.println("해당 좌석이 비어있습니다. 다시 선택하세요");
				inputInt=scan.nextInt();
				scan.nextLine();
			}
		    for(Member m: userSeat.keySet()) {
		    	if(userSeat.get(m)==inputInt) {
		    		member = m;
		    		break;
		    	}
		    }
		    System.out.println("1. 좌석 번호 변경 | 2. 입실 상태 변경");
		    sel=scan.nextInt();
		    scan.nextLine();
		    switch(sel) {
		    case 1:
		    	setSeat(member);
		    	break;
		    case 2:
		    	manageStatus(member);
		    	break;
		    default:
		    	System.out.println("잘못된 입력입니다. 처음 화면으로 돌아갑니다.");
		    	curSeat();
		    }
			break;
		default:
			curSeat();
		}
	}
	
	@Override
	public void setSeat(Member m) {
		//좌석 매칭(해시맵 생성)
		System.out.println("원하는 좌석번호: ");
		inputInt=scan.nextInt();
		scan.nextLine();
		//이미 번호가 존재하면 등록 불가; 없으면 등록
		while(userSeat.containsValue(inputInt)) {
			System.out.println("불가능한 좌석입니다. 다른 번호를 선택해주세요: ");
			inputInt=scan.nextInt();
			scan.nextLine();
		}
		//변경: 인스턴스 변수가 이미 hash에 등록되어있으므로 seatNo 값 변경(put, replace)
		//지정: 인스턴스 변수가 hash에 등록되어 있지 않음-> 새로 등록(put)
		//어차피 put 메소드로 동일하게 작동
		userSeat.put(m, inputInt);
		System.out.println("등록/수정 완료. 등록된 좌석을 조회합니다.");
		curSeat();
	}
	
	public void manageStatus(Member m) {
		System.out.println("1. 입실 | 2. 퇴실");
    	sel=scan.nextInt();
    	scan.nextLine();
    	switch(sel) {
    	case 1:
    		m.checkin();
    		curSeat();
    		break;
    	case 2:
    		m.checkout();
    		curSeat();
    		break;
    	default:
    		System.out.println("잘못된 입력입니다. 다시 선택하세요");
    		manageStatus(m);
    	}
	}
	
	@Override
	public void editMember() {
		System.out.println("수정할 회원 번호 선택");
		sel=scan.nextInt();
		scan.nextLine();
		//genMember()에서 userList의 인덱스를 따로 지정하지 않으므로 index 크기 비교로 회원의 존재 판별
		while(sel>=userList.size()) {
			System.out.println("해당 회원이 존재하지 않습니다. 다시 선택하세요: ");
			sel=scan.nextInt();
			scan.nextLine();
		}
		member=userList.get(sel);
		System.out.println(member.getName()+"회원 선택됨");
		System.out.println("수정할 요소 선택");
		System.out.println("1. 이름 | 2. 나이 | 3. 직업 |  4. 등록일수 | 5. 좌석 번호");
		sel=scan.nextInt();
		scan.nextLine();
		switch(sel) {
		case 1:
			System.out.print("이름 입력: ");
			inputStr= scan.nextLine();
			member.setName(inputStr);
			System.out.println("이름: "+inputStr+" 수정 완료");
			break;
		case 2:
			System.out.print("나이 입력: ");
			inputInt= scan.nextInt();
			scan.nextLine();
			member.setAge(inputInt);
			System.out.println("나이: "+inputInt+" 수정 완료");
			break;
		case 3:
			System.out.print("직업 입력: ");
			inputStr=scan.nextLine();
			scan.nextLine();
			member.setJob(inputStr);
			System.out.println("직업: "+inputStr+" 수정 완료");
			break;
		case 4:
			System.out.print("등록일수 입력: ");
			inputInt=scan.nextInt();
			scan.nextLine();
			member.setPeriod(inputInt);
			System.out.println("등록일수: "+inputInt+" 수정 완료");
			break;
		case 5:
			setSeat(member);
			break;
		default:
			System.out.println("잘못된 번호입니다. 처음 화면으로 돌아갑니다.");
			editMember();
		}
		System.out.println("메인화면으로 돌아갑니다.");
		start();
	}
}
