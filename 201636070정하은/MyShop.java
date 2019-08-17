package project;

import java.util.*;

// IShop 인터페이스를 구현한 MyShop 클래스
public class MyShop {

	// 등록 상품 정보 배열
	ArrayList<Product> productList = new ArrayList<>();

	// 상품 추가를 위한 선택 목록
	ArrayList<Product> checkList = new ArrayList<>();

	// 키보드 입력으로 문자열 입력받기 위한 Scanner 객체 생성
	Scanner sc = new Scanner(System.in);

	// 카페 이름
	String cafe;

	int totalPrice = 0;

	/*
	 * 프로그램에서 사용하기 위한 예제 상품 등록 메서드
	 */
	public void setTitle(String cafe) {
		this.cafe = cafe;
	}

	/*
	 * 프로그램에서 사용하기 위한 예제 기본 상품 등록 메서드
	 */
	public void generateProduct() {
		productList.add(new Product("아메리카노", 3500));
		productList.add(new Product("오렌지주스", 4500));
		productList.add(new Product("핫초코\t", 3000));
		productList.add(new Product("아이스티", 2500));
	}

	/*
	 * 프로그램에서 사용하기 위한 예제 상품 추가 메서드
	 */
	public void addProduct(String name, int price) {
		productList.add(new Product(name, price));
	}

	/*
	 * 프로그램 메인 시작 메서드
	 */
	public void start() {
		System.out.println();
		System.out.println("[ " + cafe + " ]");
		System.out.println("==============================");
		System.out.println("0: 제품 추가 (카페 점주만 이용바랍니다.)");
		System.out.println("1: 제품 선택");
		System.out.println("2: 선택 목록");
		System.out.println("3: 나가기");

		while (true) {
			System.out.print("원하는 메뉴를 입력해주세요 : ");
			String selected = sc.next();

			if (selected.equals("0")) { // 제품 추가
				showProductInput();
				break;
			} else if (selected.equals("1")) { // 제품 선택
				showProductList();
				break;
			} else if (selected.equals("2")) { // 장바구니
				showBasketList();
				break;
			} else if (selected.equals("3")) { // 나가기
				System.out.println("이용해주셔서 감사합니다.");
				System.exit(0);
			} else { // 잘못된 입력
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	/*
	 * 새롭게 상품을 추가하는 메서드
	 */
	public void showProductInput() {
		System.out.println();
		System.out.println("[ 제품 추가 ]");
		System.out.println("==============================");

		while (true) {
			System.out.print("추가하려는 제품명을 입력해주세요 : ");
			String name = sc.next();
			System.out.print("해당 제품의 가격을 입력해주세요 : ");
			String price = sc.next();
			try {
				addProduct(name, Integer.parseInt(price));
				break;
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다.");
			}
		}

		System.out.println("제품 추가가 완료되었습니다.");
		start();
	}

	/*
	 * 상품 목록을 보고 상품을 선택해 장바구니에 넣기 위한 메서드
	 */
	public void showProductList() {
		System.out.println();
		System.out.println("[ 제품 선택 ]");
		System.out.println("==============================");

		// 등록된 상품 정보 출력
		for (int i = 1; i <= productList.size(); i++) {
			System.out.print(i + ": ");
			productList.get(i - 1).print();
			System.out.println();
		}
		System.out.println("==============================");
		System.out.println("a: 선택목록 보기");
		System.out.println("p: 결제하기");
		System.out.println("0: 홈으로");

		while (true) {
			System.out.print("원하는 제품 번호나 실행 버튼을 선택해주세요 : ");
			String selected = sc.next();

			if (selected.equals("0")) {
				start();
				break;
			} else if (selected.equals("a")) {
				showBasketList();
				break;
			} else if (selected.equals("p")) {
				showPayment();
				break;
			} else {
				try {
					int s = Integer.parseInt(selected);
					if (s >= productList.size() + 1) {
						System.out.println("잘못된 입력입니다.");
					} else {
						Product p = productList.get(s - 1);
						checkList.add(p);
						System.out.println("\n선택 목록에 추가되었습니다.");
						showProductList();
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력입니다.");
				}
			}
		}
	}

	/*
	 * 선택 목록을 보기 위한 메서드
	 */
	public void showBasketList() {
		System.out.println();
		System.out.println("[ 선택목록 ]");
		System.out.println("==============================");

		// 등록된 상품 정보 출력
		for (int i = 0; i < checkList.size(); i++) {
			checkList.get(i).print();
			System.out.println();
		}
		System.out.println("==============================");
		System.out.println("p: 결제하기");
		System.out.println("c: 선택 목록 비우기");
		System.out.println("0: 홈으로");

		while (true) {
			System.out.print("원하는 메뉴를 입력해주세요 : ");
			String selected = sc.next();

			if (selected.equals("0")) {
				start();
				break;
			} else if (selected.equals("p")) {
				showPayment();
				break;
			} else if (selected.equals("c")) {
				checkList.clear();
				totalPrice=0;
				System.out.println("선택 목록을 비웠습니다.");
				start();
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	/*
	 * 결제 진행을 위한 체크아웃 처리 메서드
	 */
	public void showPayment() {
		System.out.println();
		System.out.println("[ 결제하기 ]");
		System.out.println("==============================");

		if (checkList.size() == 0) {
			System.out.println("선택 목록이 비어있습니다.");
			start();
			return;
		}

		// 선택 목록에 등록된 상품 정보 출력
		for (int i = 0; i < checkList.size(); i++) {
			checkList.get(i).print();
			System.out.println();
			totalPrice += checkList.get(i).price;
		}
		System.out.println("==============================");
		System.out.println("1: 현금 결제");
		System.out.println("2: 카드 결제");
		System.out.println("3: 포인트 적립");

		while (true) {
			System.out.print("결제 방법을 선택해주세요 : ");
			String selected = sc.next();

			if (selected.equals("1")) { // 현금 결제
				System.out.println("현금 결제로 진행합니다.");
				executePayment();
				break;
			} else if (selected.equals("2")) { // 카드 결제
				System.out.println("카드 결제로 진행합니다.");
				executePayment();
				break;
			} else if (selected.equals("3")) { // 포인트 적립
				addPoint();
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	/*
	 * 포인트 적립을 하기 위한 메서드
	 */
	public void addPoint() {
		System.out.println();
		System.out.println("적립하실 휴대폰 번호를 입력해주세요.");
		String phoneNumber = sc.next();
		System.out.println(phoneNumber + " 번호로 적립이 완료되었습니다.");
		System.out.println("\n1: 결제하기");
		while (true) {
			String selected = sc.next();
			if (selected.equals("1")) {
				showPayment();
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public void executePayment() {
		// 합계 출력
		System.out.println("[제품 가격] 총 " + totalPrice + " 원 입니다.");
		System.out.println("1: 결제 취소");
		System.out.println("2: 결제 진행");

		while (true) {
			System.out.print("원하는 메뉴를 입력해주세요 : ");
			String selected = sc.next();

			if (selected.equals("1")) { // 결제 취소
				checkList.clear();
				totalPrice=0;
				start();
				break;
			} else if (selected.equals("2")) { // 결제 진행
				System.out.println("결제가 완료되었습니다. 이용해주셔서 감사합니다.");
				System.exit(0);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}