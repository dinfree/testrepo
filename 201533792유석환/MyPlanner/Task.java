package planner;

/**
 * 할 일에 대한 정보를 가진 클래스
 * 
 * @author youseokhwan
 * @since 2019-08-14
 */
public class Task {
	private int index;
	private String content;
	private TaskStatus taskStatus;
	
	/**
	 * Task 클래스 생성자
	 * @param index 인덱스 번호
	 * @param content 내용
	 * @param taskStatus 작업 상태
	 */
	public Task(int index, String content, TaskStatus taskStatus) {
		this.index = index;
		this.content = content;
		this.taskStatus = taskStatus;
	}
	
	/**
	 * index를 반환하는 메소드
	 * @return 인덱스 번호
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * content를 반환하는 메소드
	 * @return 내용
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * taskStatus값에 따라 콘솔에 출력할 String을 반환하는 메소드
	 * @return 작업 상태
	 */
	public String getTaskStatus() {
		if(this.taskStatus == TaskStatus.NormalTask)
			return "보통";
		else if(this.taskStatus == TaskStatus.ImportantTask)
			return "중요";
		else
			return "완료";
	}
	
	/**
	 * 할 일을 완료하면 taskStatus값을 TaskStatus.CompletedTask로 변경
	 */
	public void setTaskStatus() {
		this.taskStatus = TaskStatus.CompletedTask;
	}
}
