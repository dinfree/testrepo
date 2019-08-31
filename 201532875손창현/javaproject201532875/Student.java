package javaproject201532875;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Student {
	private String stdNum;  // 학번
	private String name;    // 성명
	private Gender gender;  // 성별
	
	// 강의 목록 arraylist
	public static Scanner scan = new Scanner(System.in);
	ArrayList<Lecture> lectureList = new ArrayList<>();
	
	public String getStdNum() {
		return stdNum;
	}
	public void setStdNum(String stdNum) {
		this.stdNum = stdNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	// 강의 정보 입력 메서드
	public void insertLectureInfo(){
		System.out.print("\n## "+name+" 학생의 강의 정보를   [강의명,점수(double)] 순서대로 입력  ==> ");
		String info = scan.next();
		StringTokenizer st = new StringTokenizer(info,",");
		//     , 를 기준으로 split 기능 
		Lecture lecture = new Lecture();
		lecture.setLectureName(st.nextToken());
		lecture.setScore(Double.parseDouble(st.nextToken()));
		lecture.setGrade();

		lectureList.add(lecture); 
	}
	
	// 강의 정보 출력 메서드
	public void printLectureInfo() {
		System.out.println("\n============강의 정보============");
		System.out.println(" 강의명 \t 점수 \t 학점  ");
		System.out.println("===============================");
		for(Lecture lc : lectureList) {
			System.out.printf(" %s \t %.1f \t %c \n", lc.getLectureName(),lc.getScore(),lc.getGrade());
		}
	}
}
