package planner;

/**
 * 해야 할 일 목록을 관리하는 기능(조회, 추가, 삭제 등)을 가진 인터페이스
 * 
 * @author youseokhwan
 * @since 2019-08-14
 */
public interface IPlanner {
	
	/**
	 * 메인 화면을 호출하는 메소드
	 */
	void start();
	
	/**
	 * 할 일 목록을 출력하는 메소드
	 */
	void printList();
	
	/**
	 * 할 일을 추가하는 메소드
	 */
	void addTask();
	
	/**
	 * 할 일을 완료하는 메소드
	 */
	void completeTask();
	
	/**
	 * 현재 목록을 텍스트 파일로 저장하는 메소드
	 */
	void exportTextFile();
}
