package javabasic.train;

import java.util.Scanner;

public class SeatList {
	Scanner sc = new Scanner(System.in);
	String name;
	int num;
	public int selUser, selSeats;
	
	User[] users = new User[3];
	
	Seats[] seats1 = new Seats[2];
	Seats[] seats2 = new Seats[2];
	Seats[] seats3 = new Seats[2];
	
	String A[] = {"A1","A2","A3","A4"};
	String B[] = {"B1","B2","B3","B4"};
	String C[] = {"C1","C2","C3","C4"};
	String D[] = {"D1","D2","D3","D4"};
	
	public String SetName(String name) {
		this.name = name;
		return name;
	}
	public int SetNum(int num) {
		this.num = num;
		return num;
	}
	void A() {
		A[num-1] = name;
		if(selUser==0) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats1[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats1[selSeats].getPrice());
		}else if(selUser==1) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats2[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats2[selSeats].getPrice());
		}else if(selUser==2) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats3[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats3[selSeats].getPrice());
		}
		System.out.println("<<예약 완료>>");
	}
	public void Acancel() {
		for(int i=0; i<A.length; i++) {
			if(A[i].equals(name)) {
				A[i]=String.format("A%d", i+1);
				System.out.println("<<취소 완료>>");
				break;
			}else if(!A[i].equals(name)) {
				System.out.println("일치하는 이름이 없습니다.");
				break;
			}
		}
	}
	void B() {
		B[num-1] = name;
		if(selUser==0) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats1[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats1[selSeats].getPrice());
		}else if(selUser==1) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats2[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats2[selSeats].getPrice());
		}else if(selUser==2) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats3[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats3[selSeats].getPrice());
		}
		System.out.println("<<예약 완료>>");
	}
	public void Bcancel() {
		for(int i=0; i<B.length; i++) {
			if(B[i].equals(name)) {
				B[i]=String.format("B%d", i+1);
				System.out.println("<<취소 완료>>");
				break;
			}else if(!B[i].equals(name)) {
				System.out.println("일치하는 이름이 없습니다.");
				break;
			}
		}
	}
	void C() {
		C[num-1] = name;
		if(selUser==0) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats1[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats1[selSeats].getPrice());
		}else if(selUser==1) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats2[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats2[selSeats].getPrice());
		}else if(selUser==2) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats3[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats3[selSeats].getPrice());
		}
		System.out.println("<<예약 완료>>");
	}
	public void Ccancel() {
		for(int i=0; i<C.length; i++) {
			if(C[i].equals(name)) {
				C[i]=String.format("C%d", i+1);
				System.out.println("<<취소 완료>>");
				break;
			}else if(!C[i].equals(name)) {
				System.out.println("일치하는 이름이 없습니다.");
				break;
			}
		}
	}
	void D() {
		D[num-1] = name;
		if(selUser==0) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats1[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats1[selSeats].getPrice());
		}else if(selUser==1) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats2[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats2[selSeats].getPrice());
		}else if(selUser==2) {
			System.out.printf("## %s(%s) A%d %s ##\n",users[selUser].getUsertype(),seats3[selSeats].getSeatType(),num,name);
			System.out.printf("%d원 입니다.\n",seats3[selSeats].getPrice());
		}
		System.out.println("<<예약 완료>>");
	}
	public void Dcancel() {
		for(int i=0; i<D.length; i++) {
			if(D[i].equals(name)) {
				D[i]=String.format("D%d", i+1);
				System.out.println("<<취소 완료>>");
				break;
			}else if(!D[i].equals(name)) {
				System.out.println("일치하는 이름이 없습니다.");
				break;
			}
		}
	}

}
