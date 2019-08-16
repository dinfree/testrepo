package javaproject201532875;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class University implements UniversityInterface {
	
	private String title;
	ArrayList<Student> studentList = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void genStudent() {
		
		System.out.print("\n## 학생 정보를  [학번,성명,성별(Man/Woman)] 순서대로 입력 ==> ");
		String info = scan.next();
		StringTokenizer st = new StringTokenizer(info,",");
		
		Student student = new Student();
		student.setStdNum(st.nextToken());
		student.setName(st.nextToken());
		student.setGender(Gender.valueOf(st.nextToken()));
		while(true) {
			System.out.println("\n [1] 강의정보 추가  / 다른 키 입력 시 전 화면으로 돌아갑니다.   (** 처음에 강의정보를 추가하고 넘어가세요! **)");
			System.out.print("입력 ==> ");
			String sel = scan.next();
			if (sel.equals("1"))
				student.insertLectureInfo();
			else
				break;
		}
		studentList.add(student);
		
	}

	@Override
	public void genStudentInfo() {
		System.out.println("============학생 정보 목록============");
		System.out.println(" 번호   학번 \t\t성명\t성별  ");
		System.out.println("===============================");
		int i = 1;
		for (Student s : studentList) {
			System.out.printf(" %d   %s \t%s\t%s \n",i++,s.getStdNum(),s.getName(),s.getGender());
		}
	}
	@Override
	public void genLectureInfo() {
		System.out.print("강의 정보를 출력하고자 하는 학생의 [번호]를 입력 ==> ");
		String lcinfo = scan.next();
		if( Integer.parseInt(lcinfo) > studentList.size() ){
			System.out.println("<Error> 학생 번호 오류");
		}
		else {
			System.out.println("\n"+studentList.get( Integer.parseInt(lcinfo)-1 ).getName()+" 학생의 강의 정보를 출력합니다...");
			studentList.get( Integer.parseInt(lcinfo)-1 ).printLectureInfo();
		}
	}
	
	@Override
	public void launch() {
		while(true) {
			String menuSelect;
			System.out.println("\n$$ "+title+" 학적 관리 프로그램 $$");
			System.out.println("[i] 학생 정보 추가");
			System.out.println("[p] 학생 정보 출력");
			System.out.println("[l] 강의 정보 출력");
			System.out.println("[x] 종료");
			System.out.print("입력 ==> ");
			menuSelect = scan.next();
			switch (menuSelect) {
				case "i": genStudent(); break;
				case "p": System.out.println();genStudentInfo(); break;
				case "l": genLectureInfo(); break;
				case "x": System.exit(0); break;
			}
		}
	}
}
