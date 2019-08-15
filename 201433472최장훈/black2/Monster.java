package javabasic.black2;

public class Monster extends CharInfo {
	//CharInfo의 멤버 변수들을 상속받았지만, 임의로 변경하거나 삭제한 것도 있다.
	//몬스터 같은 경우는 
	String name="monster";
	static int hp=10;
	static int strong=10;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getStrong() {
		return strong;
	}
	public void setStrong(int strong) {
		this.strong = strong;
	}
}
