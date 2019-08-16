package planner;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * IPlanner 인터페이스를 구현한 MyPlanner 클래스
 * 
 * @author youseokhwan
 * @since 2019-08-14
 */
public class MyPlanner implements IPlanner {

	private String name;
	private Scanner scanner;
	private ArrayList<Task> taskList;
	
	/**
	 * MyPlanner 클래스 생성자
	 * @param name 사용자 이름
	 */
	public MyPlanner(String name) {
		this.name = name;
		scanner = new Scanner(System.in);
		taskList = new ArrayList<>();
		
		/*
		 * 입력 시간을 줄이기 위해서 임의로 미리 작성하였습니다.
		 */
		taskList.add(new Task(taskList.size()+1, "밀린 빨래하기", TaskStatus.NormalTask));
		taskList.add(new Task(taskList.size()+1, "슬리퍼 사기", TaskStatus.NormalTask));
		taskList.add(new Task(taskList.size()+1, "휴대폰 수리맡기기", TaskStatus.CompletedTask));
		taskList.add(new Task(taskList.size()+1, "철수 생일선물 사기", TaskStatus.ImportantTask));
		taskList.add(new Task(taskList.size()+1, "다음 주 부산 여행", TaskStatus.ImportantTask));
		taskList.add(new Task(taskList.size()+1, "국가장학금 신청하기", TaskStatus.CompletedTask));
		taskList.add(new Task(taskList.size()+1, "JAVA 복습하기", TaskStatus.ImportantTask));
		taskList.add(new Task(taskList.size()+1, "방 청소하기", TaskStatus.NormalTask));
	}

	@Override
	public void start() {
		printTitle();
		printMenu();
		
		// 사용자의 선택에 따라 프로그램 진행
		switch(selectNumber()) {
		case 1:
			printList();
			break;
		case 2:
			addTask();
			break;
		case 3:
			completeTask();
			break;
		case 4:
			exportTextFile();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			scanner.close();
			System.exit(0);
		default:
			System.out.print("유효하지 않은 번호입니다. 다시 선택해주세요. [Enter]");
			scanner.nextLine();  // 입력 버퍼 초기화
			System.out.print("\n\n");
			start();
		}
	}
	
	/**
	 * 화면 상단에 타이틀 출력하는 메소드
	 */
	public void printTitle() {
		System.out.println("------------------------");
		System.out.println("## " + this.name + " 님의 MyPlanner ##");
		System.out.println("------------------------");
	}
	
	/**
	 * 타이틀 하단에 메뉴 출력하는 메소드
	 */
	public void printMenu() {
		System.out.println("[1] 전체목록 조회\n[2] 할 일 추가\n[3] 할 일 완료\n"
				+ "[4] 텍스트 파일로 추출\n[5] 프로그램 종료");
	}

	/**
	 * 사용자가 메뉴 번호를 선택하여 반환하는 메소드
	 * @return 선택한 메뉴 번호
	 */
	public int selectNumber() {
		int userSelect;
		System.out.print("* 선택 : ");
	
		try {
			userSelect = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			userSelect = -1;
		}
		
		return userSelect;
	}
	
	@Override
	public void printList() {
		System.out.println("\n\n## [1] 전체목록 조회 ##");
		
		System.out.println("[1] 해야할 일 보기 [2] 중요한 일만 보기 [3] 완료한 일만 보기 [4] 전체 보기");
		System.out.print("* 선택 : ");
		int userSelect = Integer.parseInt(scanner.nextLine());
		
		System.out.println("----------------------------------------");
		System.out.println(" 번호\t상태\t\t내용");
		System.out.println("----------------------------------------");
		
		switch(userSelect) {
		case 1:
			for(Task t : taskList)
				if(!t.getTaskStatus().equals("완료"))
					System.out.println("  " + t.getIndex() + "\t" + t.getTaskStatus() + "\t" + t.getContent());
			break;
		case 2:
			for(Task t : taskList)
				if(t.getTaskStatus().equals("중요"))
					System.out.println("  " + t.getIndex() + "\t" + t.getTaskStatus() + "\t" + t.getContent());
			break;
		case 3:
			for(Task t : taskList)
				if(t.getTaskStatus().equals("완료"))
					System.out.println("  " + t.getIndex() + "\t" + t.getTaskStatus() + "\t" + t.getContent());
			break;
		default:
			for(Task t : taskList)
				System.out.println("  " + t.getIndex() + "\t" + t.getTaskStatus() + "\t" + t.getContent());
		}
		System.out.println("----------------------------------------");
		
		scanner.nextLine();  // 입력 버퍼 초기화
		System.out.println();
		start();
	}

	@Override
	public void addTask() {
		System.out.println("\n## [2] 할 일 추가 ##");
		
		System.out.print("내용 입력: ");
		String content = scanner.nextLine();
		
		System.out.print("중요한 일로 등록하시겠습니까(y/n)? ");
		String answer = scanner.nextLine();
		
		if(answer.equals("y") || answer.equals("Y"))
			taskList.add(new Task(taskList.size()+1, content, TaskStatus.ImportantTask));
		else
			taskList.add(new Task(taskList.size()+1, content, TaskStatus.NormalTask));
		
		System.out.println();
		start();
	}

	@Override
	public void completeTask() {
		System.out.println("\n## [3] 할 일 완료 ##");
		
		System.out.println("----------------------------------------");
		System.out.println(" 번호\t상태\t내용");
		System.out.println("----------------------------------------");
		
		for(Task t : taskList)
			if(!t.getTaskStatus().equals("완료"))
				System.out.println("  " + t.getIndex() + "\t" + t.getTaskStatus() + "\t" + t.getContent());
		System.out.println("----------------------------------------");
		
		System.out.print("완료할 일의 번호를 입력해주세요 : ");
		int index = Integer.parseInt(scanner.nextLine());
		
		for(Task t : taskList)
			if(t.getIndex() == index)
				t.setTaskStatus();
		
		System.out.print("\n\n");
		start();
	}

	@Override
	public void exportTextFile() {
		System.out.println("\n## [4] 텍스트 파일로 추출 ##");
		
		// 파일 경로 및 파일명 설정
		String path = "/Users/youseokhwan/Dev/";
		String fileName = "planner.txt";
		
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + fileName));
			
			bufferedWriter.write("----------------------------------------\r\n");
			bufferedWriter.write("번호\t상태\t내용\r\n");
			bufferedWriter.write("----------------------------------------\r\n");
			for(Task t : taskList)
				bufferedWriter.write(t.getIndex() + "\t" + t.getTaskStatus() + "\t" + t.getContent() + "\r\n");
			
			System.out.println("저장되었습니다.");
			System.out.println("파일 경로: " + path + fileName);
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("저장을 실패하였습니다.\n파일 경로를 확인해주세요.");
			System.out.println("현재 설정된 경로: " + path + fileName);
		}
		
		scanner.nextLine();  // 입력 버퍼 초기화
		System.out.println();
		start();
	}
	
}
