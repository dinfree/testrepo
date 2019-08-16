package planner;

/**
 * TaskStatus의 상태를 나타내는 enum
 * 
 * @author youseokhwan
 * @since 2019-08-14
 */
public enum TaskStatus {
	/**
	 * NormalTask : 해야할 일
	 */
	NormalTask,
	
	/**
	 * ImportantTask : 해야할 일(중요)
	 */
	ImportantTask,
	
	/**
	 * CompletedTask : 완료된 일
	 */
	CompletedTask
}
