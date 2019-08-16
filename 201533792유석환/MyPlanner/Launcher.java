package planner;

/**
 * 해야 할 일을 관리하는 to do list 자바 프로그램
 * 
 * @author youseokhwan
 * @since 2019-08-14
 * @version 1.0
 */
public class Launcher {

	public static void main(String[] args) {
		IPlanner planner = new MyPlanner("유석환");  // 사용자 이름을 지정
		planner.start();
	}

}
