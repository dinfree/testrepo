package javaProject.management;

public interface IManage {
	void setTitle(String title);
	void start();
	void genMember();
	void editMember();
	void setSeat(Member m);
	void curSeat();
	void defaultSet();
	void manageStatus(Member m);
}
