package javabasic.train;

public class Choose extends SeatList{
	void reservation() {
		System.out.println("~좌석배치 - 좌석 선택~");
		System.out.println("[1]A열\n[2]B열\n[3]C열\n[4]D열");
		System.out.println("[x]종 료");
		System.out.print("선택: ");
		String sel = sc.next();
		System.out.println("## "+sel+"선택 ##");
		
		if(sel.equals("1")) {
			for(int i=0; i<A.length; i++) {
				System.out.print(A[i]+" ");
			}
			System.out.println();
			System.out.print("좌석번호 선택>>");
			SetNum(sc.nextInt());
			System.out.print("예약자 이름>>");
			SetName(sc.next());
			A();
		}else if(sel.equals("2")) {
			for(int i=0; i<B.length; i++) {
				System.out.print(B[i]+" ");
			}
			System.out.println();
			System.out.print("좌석번호 선택>>");
			SetNum(sc.nextInt());
			System.out.print("예약자 이름>>");
			SetName(sc.next());
			B();
		}else if(sel.equals("3")) {
			for(int i=0; i<C.length; i++) {
				System.out.print(C[i]+" ");
			}
			System.out.println();
			System.out.print("좌석번호 선택>>");
			SetNum(sc.nextInt());
			System.out.print("예약자 이름>>");
			SetName(sc.next());
			C();
		}else if(sel.equals("4")) {
			for(int i=0; i<D.length; i++) {
				System.out.print(D[i]+" ");
			}
			System.out.println();
			System.out.print("좌석번호 선택>>");
			SetNum(sc.nextInt());
			System.out.print("예약자 이름>>");
			SetName(sc.next());
			D();
		}else if(sel.equals("x")) {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}else {
			System.out.println("다시 선택해주세요.");
			reservation();
		}
	}
	void lookup(){
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.println();
		for(int i=0; i<B.length; i++) {
			System.out.print(B[i]+" ");
		}
		System.out.println();
		for(int i=0; i<C.length; i++) {
			System.out.print(C[i]+" ");
		}
		System.out.println();
		for(int i=0; i<D.length; i++) {
			System.out.print(D[i]+" ");
		}
		System.out.println();
		System.out.println("<<조회 완료>>");
	}
	void cancel(){
		System.out.println("~예약된 좌석선택~\n[1]A열\n[2]B열\n[3]C열\n[4]D열");
		System.out.print("선택: ");
		num = sc.nextInt();
		System.out.println("## "+num+"선택 ##");
		if(num==1) {
			for(int i=0; i<A.length; i++) {
				System.out.print(A[i]+" ");
			}
			System.out.println();
			System.out.print("예약된 이름>>");
			SetName(sc.next());
			Acancel();
		}else if(num==2) {
			for(int i=0; i<B.length; i++) {
				System.out.print(B[i]+" ");
			}
			System.out.println();
			System.out.print("예약된 이름>>");
			SetName(sc.next());
			Bcancel();
		}else if(num==3) {
			for(int i=0; i<C.length; i++) {
				System.out.print(C[i]+" ");
			}
			System.out.println();
			System.out.print("예약된 이름>>");
			SetName(sc.next());
			Ccancel();
		}else if(num==4) {
			for(int i=0; i<D.length; i++) {
				System.out.print(D[i]+" ");
			}
			System.out.println();
			System.out.print("예약된 이름>>");
			SetName(sc.next());
			Dcancel();
		}
	}
}
