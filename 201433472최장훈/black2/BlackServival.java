package javabasic.black2;

import java.util.Random;
import java.util.Scanner;

public class BlackServival {
	
	public String choiceChar() {
		//게임시작 후 캐릭터를 선택하게 한다.
		//캐릭터 선택 이후 캐릭터 번호를 문자로 리턴한다.
		System.out.println("[1]쇼이치 \t [2]잭");
		System.out.print("캐릭터 번호를 선택해주세요 : ");
		Scanner scan_char = new Scanner(System.in);
		String yourChar = scan_char.next();
		System.out.printf("당신의 캐릭터 :  %s\n",yourChar);
		return yourChar;
	}
	public Character generateChar(String use_name) {
		//선택된 번호에 따라 알맞은 스탯을 갖는 캐릭터를 생성후
		//Character클래스의 인스턴스를 반환한다.
		//지정된 번호 이외의 번호를 클릭시 다시 선택하라는 문구와 함께 choiceChar()호출
		Character c = new Character();
		if(use_name.equals("1")) {
			System.out.println("쇼이치가 선택됐습니다.");
			c.setName("Shoichi");
			c.setHp(100);
			c.setStrong(10);
			c.setExp(0);
		}
		else if(use_name.equals("2")) {
			System.out.println("잭이 선택됐습니다.");
			c.setName("Jack");
			c.setHp(100);
			c.setStrong(5);
			c.setExp(0);
		}
		else {
			System.out.println("캐릭터를 다시 선택하세요.");
			choiceChar();
		}
		return c;
	}
	
	public void moveArea() throws InterruptedException {
		/* 이동할 지역을 보여준다.
		 * 선택을 스캐너로 받아서, 선택에 따른 문장을 출력한다.
		 * Thread.sleep()을 통해 로딩을 포현했고, 예외처리를 위해 throws를 추가했다.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("[1]고급주택가 \t [2]병원 \t [3]소방서 \t [4]공장");
		System.out.print("지역들을 선택하세요 : ");
		int area_select = scan.nextInt();
		System.out.println("(이동중)");
		Thread.sleep(1500);
		System.out.println("(뚜벅뚜벅)");
		Thread.sleep(2000);
		switch(area_select) {
		case 1 : //고급주택가 진입시의 멘트를 출력 
			System.out.println("<고급주택가>");
			Thread.sleep(500);
			System.out.println("높은 담장을 가진 집들이 있는 동네이다.");break;
		case 2 : //병원에 진입시 멘트를 출력
			System.out.println("<병원>");
			Thread.sleep(500);
			System.out.println("약병이 여기저기 꺼내어져 있다.");break;
		case 3 : //소방서에 진입시 멘트를 출력
			System.out.println("<소방서>");
			Thread.sleep(500);
			System.out.println("소방호스가 차고앞에 뒹굴고 있다.");break;
		case 4 : //공장에 진입시 멘트를 출력
			System.out.println("<공장>");
			Thread.sleep(500);
			System.out.println("기계들이 녹이 슨지 매우 오래된 것 같다.");break;
		default :
			System.out.println("다시 선택하세요.");
			moveArea();
			break;
		}
	}
	
	public void explore(Character chinfo) throws InterruptedException {
		/* 몬스터 출현, 아이템 획득, 경험치 획득, 아무것도 없을 때 총 네 가지의 상황을 확률적으로 구현하기 위해
		 * Random 인스턴스를 생성했다.
		 * 특히 몬스터와 싸울때, 플레이어의 체력이 0이하가 될 경우에는 게임오버 판정으로 간주하여 시스템이 종료된다.
		 * 
		 */
		Random random = new Random();
		Scanner scan_explore = new Scanner(System.in);
		int result = random.nextInt(4);
		System.out.println("탐험중...");
		System.out.println("(뚜벅뚜벅)");
		//Thread.sleep(1000);
		switch(result) {
		case 0 : //몬스터 출현
			System.out.println("몬스터 출현!!!");
			System.out.print("[1]싸운다 \t [2]도망간다 : ");
			int monster_result = scan_explore.nextInt();			
			Monster monster = new Monster();
			int monhp = monster.getHp();
			int chinfo_hp = chinfo.getHp();
			int chinfo_exp = chinfo.getExp();
			if(monster_result == 1) {
				do {
					System.out.println("플레이어의 공격!!");
					Thread.sleep(200);
					System.out.printf("%s 가 %s 에게 %d 만큼 데미지를 주었습니다.\n", 
							chinfo.getName(), monster.getName(), chinfo.getStrong());
					monhp -= chinfo.getStrong(); //캐릭터 공격력 만큼 몬스터의 체력감소
					//monster.setHp(monhp);
					System.out.printf("%s의 체력 : %d \t%s의 체력 : %d\n", 
							chinfo.getName(), chinfo.getHp(), monster.getName(), monhp);

					
					if(monhp <=0) {
						System.out.println("몬스터의 hp가0이 되어 몬스터가 쓰러졌습니다.");
						System.out.println("경험치10을 획득합니다.");
						chinfo_exp+=10;
						chinfo.setExp(chinfo_exp);
						return ;
					}
					
					System.out.println("몬스터의 공격!!");
					Thread.sleep(200);
					System.out.printf("%s 가 %s 에게 %d 만큼 데미지를 주었습니다.\n", 
							monster.getName(), chinfo.getName(), monster.getStrong());
					chinfo_hp -= monster.getStrong();// 몬스터 공격력 만큼 캐릭터 체력감소
					chinfo.setHp(chinfo_hp);
					System.out.printf("%s의 체력 : %d \t%s의 체력 : %d\n", 
							chinfo.getName(), chinfo.getHp(), monster.getName(), monhp);

					
					if(chinfo.getHp() <=0) {
						System.out.println("캐릭터의 hp가0이 되어서 게임을 진행 할 수 없습니다.");
						System.out.println("게임종료");
						System.exit(0);
					}
					
					System.out.print("[1]싸운다 \t [2]도망간다 \t [3]아이템사용: ");
					monster_result = scan_explore.nextInt();
					if(monster_result==3) {
						itemControl(chinfo);
					}
				} while(monster_result !=2);
			}
			break;
		case 1 : //아무것도 없을 때
			System.out.println("아무것도 발견하지 못했다.");
			break;
		case 2 : //아이템 획득
			if(chinfo.getItemCounter() < 3) {
				System.out.println("아이템을 획득했다.");
				itemGain(chinfo);
			}
			else System.out.println("아이템을 발견했지만, 가방이 꽉 찼습니다.");
			break;
		default :
			chinfo_exp = chinfo.getExp();
			chinfo_exp +=10;
			chinfo.setExp(chinfo_exp);
			System.out.println("경험치를 획득했다.");
			break;
		}
	}
	
	public void itemControl(Character chinfo) {
		/* 플레이어의 UI에서, [3] 아이템 항목을 선택했을 때 상황을 위한 함수다
		 * Character클래스에서 itemBox를 ArrayList로 정의했기에 
		 * 그와 관련된 isEmpty()함수등이 쓰였다.
		 * 현재는 힐링포션(체력을30회복)만 구현됨.
		 */
		if(chinfo.getItemBox().isEmpty()) {
			System.out.println("아이템이 없습니다.!!");
			return ;
		}
		else {
			System.out.println("아이템이 있습니다.");
			System.out.println("아이템 현황");
			System.out.println(chinfo.getItemBox());
			Scanner scan = new Scanner(System.in);
			int itemUse = 100;
			int charHp = 0;
			System.out.println("아이템을 사용하시겠습니까?");
			System.out.print("[1]Yes \t [2]No : ");
			itemUse = scan.nextInt();
			if(itemUse == 1) {
				System.out.println("힐링 포션을 사용합니다.");
				charHp = chinfo.getHp();
				charHp += 30;
				chinfo.setHp(charHp);
				chinfo.removeItemBox();
				chinfo.setItemCounter(-1);
				System.out.println("체력을 30 회복했습니다.");
			}
			else {
				return ;
			}
		}
	}
	

	public void itemGain(Character chinfo) {
		/* 플레이어의 UI 에서 [1]탐험을 선택했을 때 벌어지는 일 중 아이템 획득과 관련한 함수다.
		 * 
		 * 
		 */
		chinfo.setItemCounter(1);
		System.out.println("힐링포션 획득!");
		chinfo.setItemBox("힐링포션");
		System.out.println("<아이템 현황>");
		System.out.println(chinfo.getItemBox());
	}
	
	
	public void start() throws InterruptedException {
		
		System.out.println("블랙 서바이벌에 오신 것을 환영합니다.");
		
		String use_name= choiceChar(); //캐릭터 선택창을 띄운다.
		Character chinfo = new Character(); //캐릭터가 선택되면, 해당하는 캐릭터의 정보가 형성된다.
		chinfo = generateChar(use_name); //이때 chinfo라는 인스턴스 변수를 통해 캐릭터의 hp등 정보가 변동시 바뀌게 한다.
		System.out.println("절망의 끝까지 도달한 폰에게 모든 영광을");
		//최초 시작은 공장이므로 공장 진입시의 멘트가 삽입
		System.out.println("<공장>");
		System.out.println("기계들이 녹이 슨지 매우 오래된 것 같다.");
		int select=10;
		Scanner scan_menu = new Scanner(System.in);
		//이하는 플레이어의 인터페이스
		do {
			System.out.printf("Name : %s \t HP : %d \t EXP : %d\n", 
					chinfo.getName(), chinfo.getHp(), chinfo.getExp());
			System.out.println("[1]탐험 \t [2]지역이동 \t [3]아이템 \t [0]종료");
			System.out.print("행동을 선택하세요 : ");
			select = scan_menu.nextInt();
			switch(select) {
			case 1 : 
				System.out.println("탐험선택");
				explore(chinfo);
				break;
			case 2 : 
				System.out.println("지역이동선택");
				moveArea();
				break;
			case 3 : 
				System.out.println("아이템 선택");
				itemControl(chinfo);
				break;
			case 0 : 
				System.out.println("종료선택");
				break;
			default :
				System.out.println("다시 선택하세요");
				break;
			}
		}
		while(select !=0); //UI에서 [0]선택시 종료
		System.out.println("게임이 종료됐습니다.");
	}

	
}
