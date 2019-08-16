package MyGame;
import java.util.*;

public class Mygame implements IGame {
	
	int i;
	int index;
	int userindex = 0;
	int usercount;
	
	Scanner scan = new Scanner(System.in);
	
	ArrayList<gameUser> users = new ArrayList<gameUser>();
	ArrayList<ArrayList<Character>> usercharacters = new ArrayList<ArrayList<Character>>(); 
	
	
	public void genUser() {
		// TODO Auto-generated method stub
		System.out.print("생성할 아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();
		gameUser user = new gameUser(id,password);
		users.add(user);
		System.out.println("회원가입에 성공하셨습니다.");
		ArrayList<Character> characters = new ArrayList<Character>();
		usercharacters.add(characters);
		userindex++;
		start();
	}

	//@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("[0] 로그인");
		System.out.println("[1] 회원가입");
		System.out.println("[2] 유저 목록");
		System.out.println("[3] 프로그램 종료");
		
		Scanner scan = new Scanner(System.in);
		String sel = scan.next();
		switch(sel)
		{
		case "0":
			login();
			break;
		case "1":
			genUser();
			break;
		case "2":
			userList();
			start();
			break;
		default:
			System.out.println("시스템을 종료합니다.");
			System.exit(0);
		
		}
		scan.close();

	}

	public void genCharacter() {
		
		System.out.println("캐릭터 생성/삭제");
		System.out.println("[0]캐릭터 생성");
		System.out.println("[1]캐릭터 삭제");
		System.out.println("[2]이전화면");
		String sel = scan.next();
		switch(sel)
		{
		case "0":
			System.out.println("캐릭터를 생성합니다.");
			characterCreate();
			break;
		case "1":
			System.out.println("캐릭터를 삭제합니다.");
			characterDelete();
			break;
			default:
				userChoice();
			break;
		
				
		}
		scan.close();				
	}
	public void userList() {
		userindex = 0;
		for(gameUser s : users) {
			System.out.printf("유저 아이디 : %s\n",users.get(userindex).username);
			userindex++;
		}
	}
	public void userChoice() {
		System.out.println("## 선택 ##");
		System.out.println("[0]캐릭터 생성/삭제");
		System.out.println("[1]캐릭터 리스트 조회");
		System.out.println("[2]로그아웃");
		String sel = scan.next();
		
		switch(sel){
		
		case "0":
			genCharacter();
			break;
		case "1":
			characterList();
			userChoice();
			break;
		default:
			start();
			break;
		}
		scan.close();	
	}
	public void characterCreate() {
		System.out.println("## 캐릭터 직업 선택 ##");
		System.out.println("[0]전사");
		System.out.println("[1]마법사");
		System.out.println("[2]궁수");
		System.out.println("[3]도적");
		System.out.println("[4]이전화면");
		
		index = usercharacters.get(usercount).size();
		String name;
		String sel = scan.next();
		
		switch(sel) {
		case "0":
			Warrior warrior = new Warrior();
			usercharacters.get(usercount).add(warrior);
			System.out.print("캐릭터 이름 : ");
			name = scan.next();
			usercharacters.get(usercount).get(index).charactername(name);
			choicesex(usercharacters.get(usercount).get(index));
			index++;
			System.out.println("캐릭터를 생성하셨습니다.");
			userChoice();
			break;
		case "1":
			Magicion magicion = new Magicion();
			usercharacters.get(usercount).add(magicion);
			System.out.print("캐릭터 이름 : ");
			name = scan.next();
			usercharacters.get(usercount).get(index).charactername(name);
			choicesex(usercharacters.get(usercount).get(index));
			index++;
			System.out.println("캐릭터를 생성하셨습니다.");
			userChoice();
			break;
		case "2":
			Archur archur = new Archur();
			usercharacters.get(usercount).add(archur);
			System.out.print("캐릭터 이름 : ");
			name = scan.next();
			usercharacters.get(usercount).get(index).charactername(name);
			choicesex(usercharacters.get(usercount).get(index));
			index++;
			System.out.println("캐릭터를 생성하셨습니다.");
			userChoice();
			break;
		case "3":
			Log log = new Log();
			usercharacters.get(usercount).add(log);
			System.out.print("캐릭터 이름 : ");
			name = scan.next();
			usercharacters.get(usercount).get(index).charactername(name);
			choicesex(usercharacters.get(usercount).get(index));
			index++;
			System.out.println("캐릭터를 생성하셨습니다.");
			userChoice();
			break;
		default:
			genCharacter();
			break;
		}
		scan.close();
	}
	public void characterDelete() {
		i = 0;
		System.out.println("삭제할 캐릭터 선택");
		for(Character s : usercharacters.get(usercount)) {
			System.out.printf("[%d]%s\n",i,usercharacters.get(usercount).get(i).name);
			i++;	
		}
		String sel = scan.next();
		int psel = Integer.parseInt(sel);
		usercharacters.get(usercount).remove(usercharacters.get(usercount).get(psel));
		System.out.println("캐릭터를 삭제하셨습니다.");
		index--;
		userChoice();
		
	}
	public void characterList() {
		System.out.println("## 캐릭터 리스트 ##");
		for(int i = 0; i < usercharacters.get(usercount).size(); ++i) {
			System.out.printf("[%d]\n이름 : %s\n성별 : %s\n직업 : %s\n"
					+ "힘 : %d\n민첩 : %d\n지력 : %d\n행운 : %d\n",
					i,usercharacters.get(usercount).get(i).name,usercharacters.get(usercount).get(i).sex,
					usercharacters.get(usercount).get(i).job, usercharacters.get(usercount).get(i).STR,
					usercharacters.get(usercount).get(i).DEX, usercharacters.get(usercount).get(i).INT, 
					usercharacters.get(usercount).get(i).LUX);
		}
		userChoice();
	}
	public void choicesex(Character chalist) {
		System.out.println("## 캐릭터 성별 선택 ##");
		System.out.println("[0]남자");
		System.out.println("[1]여자");
		
		String choice = scan.next();
		switch(choice)
		{
		case "0":
			chalist.charactersex("Male");
			break;
		case "1":
			chalist.charactersex("Female");
			break;
		default:
			System.out.println("0또는1만 입력하세요.");
			choicesex(chalist);
			break;
		}
		
	}
	public void login() {
		int num = 0;
		usercount = 0;
		index = 0;
		
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();
		
		for(int i = 0; i <= userindex ; ++i) {
			if(users.get(i).username.equals(id) && 
					users.get(i).password.equals(password)) {
				num++;
				break;
				
			}
			else
				usercount++;
		}
		if(num != 0)
		{
			System.out.println("로그인에 성공하셨습니다.");
			System.out.printf("유저 아이디 : %s\n%d",id,usercount);
			userChoice();
		}
		else {
			System.out.println("회원정보가 없습니다.");
			start();
		}
	}

}
