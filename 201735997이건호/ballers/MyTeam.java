package Ballers;

import java.io.*;
import java.util.*;

public class MyTeam {
	//등록된 감독 arraylist
	ArrayList<User> users = new ArrayList<User>();
	
	//존재하는 선수 arraylist
	ArrayList<Player> players = new ArrayList<Player>();
	//내가 꾸린 선수 arraylist
	ArrayList<Player> myPlayers = new ArrayList<Player>();
	//키보드 입력을 받기 위한 Scanner 객체 생성
	Scanner scan = new Scanner(System.in);
	//선택된 감독 index 보관
	int selUser;
	//내 올스타 팀 이름
	String myteam;
	
	public void setMyteam(String myteam) {
		this.myteam=myteam;
	}
	
	public void start() { //프로그램 시작 메소드
		System.out.println("메인화면 - 감독님을 선택해주세요");
		System.out.println("========================");
		int i=0;
		
		// 등록된 사용자 정보 출력
		for(User u : users) {
			System.out.printf("[%d]%s(%s)\n",i++,u.getName(),u.getId());
		}
		
		System.out.println("[x]종 료");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "x": System.exit(0);break;
			default:
				selUser = Integer.parseInt(sel);
				playerList();
		}
	}
	//선수 명단 불러오기 
	public void playerList() {
		//선택한 감독
		System.out.println(users.get(selUser)+" 감독님!  선수를 선택해주세요.");
		System.out.println("=========================");
		
		//선수들 메모장에서 불러오고 선수 arraylist에 등록하기
		BufferedReader reader = null;
		try {
			String s; 
			String[] array_word;
			File file = new File("C:/Users/Rhee/players.txt"); 
			reader = new BufferedReader(new FileReader(file));
			while((s = reader.readLine())!=null) {
				int c=1;
				Player p = new Player();
				System.out.print("["+c+"] ");
				System.out.println(s);
				array_word=s.split("\\s+"); //공백을 기준으로 split
				for(int i=0; i< array_word.length; i++) {
					int del=i%3;
					switch(del) {
					case 0: p.setName(array_word[i]); //첫 번째 단어 이름으로 저장
					case 1: p.setBacknum(array_word[i]); //두 번째 단어 등번호로 저장
					case 2: Team teamEnum = Team.valueOf(array_word[i]); p.setTeam(teamEnum); //세 번째 단어 팀이름 enum으로 변환
					}
				}
				players.add(p); //players arraylist에 저장
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader!=null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		System.out.println("[h]메인화면");
		System.out.println("[s]선수선택완료 -> 저장");
		System.out.print("선택 : ");
		String sel = scan.next();
		System.out.println("## "+sel+"선택 ##");
		
		switch(sel) {
		//case "h":start();break;
		case "s":save();break; //선택한 선수를 메모장에 저장 
		default:
			int psel = Integer.parseInt(sel);
			myPlayers.add(players.get(psel)); //선택한 선수를 내 선수들 arraylist에 저장
			playerList();
	}
}
	//내 선수들 파일 저장
	public void save() {
		System.out.println(users.get(selUser)+" : 선수 파일 저장");
		System.out.println("=========================");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("./"+users.get(selUser)+".txt")); //파일 저장 ex) "유명한.txt"
			for(Player p: myPlayers) {
				int i=1;
				writer.write("["+Integer.toString(i++)+"] "+ p.getName()+" "+p.getBacknum()+" "+p.getTeam().name()+"/r/n"); //myPlayers의 선수 객체를 문자열로 저장 ex) "[1] 강백호 7 SHOHOKU" 
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	//감독 생성
	public void genUser() { 
		User user = new User("안한수","Ahn");
		users.add(user);
		user = new User("유명호","Fame");
		users.add(user);
	}
		
	
		
}

