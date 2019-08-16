package memo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MS implements Manager {
	 Scanner sc = new Scanner(System.in);
	 List<User> members = new ArrayList<>();
	 String path = "c://javamemo//";
    public void start() {
        
    	System.out.println("1.로그인  | 2.사용자 생성  | 3.사용자 목록  | 0.종료");
        String key =  sc.next();
        sc.nextLine();
        if (key.equals("1")) {Login();}
        else if(key.equals("2")) {newUser();}
        else if(key.equals("3")) {Userlist();}
        else if(key.equals("0")) {System.out.println("프로그램 종료.");System.exit(0);}
        else {System.out.println("0~3 숫자를 입력해주세요."); start();}
        }
    
 
	
	public void Login() {
		
		System.out.println("id 입력하시오: ");
		String id = sc.nextLine();
		System.out.println("password 입력하시오: ");
		String ps = sc.nextLine();
		
		for(User user : members) {
			if(user.getID().equals(id)) {
				if(user.getPassword().equals(ps)) {
					System.out.println("로그인 되었습니다.");
					File file = new File(path);
					if(!file.exists()) {
						file.mkdirs();
						System.out.println("c://javamemo 디렉터리 생성");
					}
					Mstart();
				}
				else {
					System.out.println("비밀번호 오류.");
				}
			}
		}
		start();
	}
	
	public void newUser() {

		System.out.println("생성할 아이디 입력: ");
		String id = sc.nextLine();
		System.out.println("비밀번호 입력: ");
		String password = sc.nextLine();
		
		User u = new User();
		u.setID(id);
		u.setPassword(password);
		members.add(u);
		start();
	}
	
	public void Userlist() {
		for(User us : members) {
			System.out.println("아아디: " + us.getID());
		}
	start();
	}
	
	public void Mstart() {
		System.out.println("1.메모장 생성  | 2.메모장 삭제  | 3.메모장 목록  | 4.메모장 열기  | 5.메인메뉴로 돌아가기  | 0.종료(메모 및 디렉터리 삭제)");
        String key = sc.next();
        if (key.equals("1")) {newMemo();}
        else if(key.equals("2")) {DeleteMemo();}
        else if(key.equals("3")) {Memolist();}
        else if(key.equals("4")) {OpenMemo();}
        else if(key.equals("5")) {start();}
        else if(key.equals("0")) {
        	File direc = new File(path);
        	if(direc.exists()) {
        		File[] direcList = direc.listFiles();
        		for(int i=0;i<direcList.length;i++) {
        			direcList[i].delete();
        		}
        		if(direcList.length == 0) {
        			direc.delete();
        		}
        	}
        	System.out.println("javamemo 디렉터리 및 디렉터리 내의 모든 메모 삭제");
        	System.exit(0);
        }
        else {System.out.println("0~5 숫자를 입력해주세요."); Mstart();}
	}
	
	public void newMemo() {
		System.out.println("생성할 메모장 이름 입력(확장자 입력 x): ");
		String filename = sc.next()+".txt";
		File file = new File(path+filename);
		try{
			if(file.createNewFile()) {
				System.out.println(filename+"가 생성되었습니다.");
			}
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("파일 생성 과정에서 오류 발생.");
		}
		
		try {
			Desktop.getDesktop().edit(new File(path + filename));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("실행 불가.");
		}
		Mstart();
	}
	
	public void DeleteMemo() {
		System.out.println("삭제할 메모장 선택(확장자 입력 x): ");
		String filename = sc.next()+".txt";
		File file = new File(path + filename);
		if(file.exists()) {
			file.delete();
			System.out.println("삭제 성공.");
		}
		else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		Mstart();
	}
	public void Memolist() {
		File direc = new File(path);
    	File[] direcList = direc.listFiles();
    	if(direcList.length>0) {
    		for(int i=0;i<direcList.length;i++) {
    			
   			System.out.println(direcList[i].getName());
    		}
    	}
    	else {
    		System.out.println("메모장이 존재하지 않습니다.");
    	}
    	Mstart();
    }
	public void OpenMemo() {
		System.out.println("열고싶은 메모장 선택(확장자 입력 x): ");
		String filename = sc.next()+".txt";
		File file = new File(path + filename);
		
		try {
			if(file.exists()) {
			Desktop.getDesktop().edit(new File(path + filename));
			}
			else {
				System.out.println("없는 메모장 입니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Mstart();
	}
	
}