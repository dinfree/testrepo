package shoppingmall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class ShopMenu {
    //고객이 장바구니에 담은 상품 번호를 저장할 리스트
	ArrayList<Integer> cart = new ArrayList<Integer>();

	Scanner scan = new Scanner(System.in);

	public void start() {
	    cart.clear();
		System.out.println("메뉴 종류 선택");
		System.out.println("========================");
		System.out.println("1. 구매자 메뉴");
		System.out.println("2. 판매자 메뉴");

		System.out.println("q. 종 료");
		System.out.print("선택 : ");
		String sel = scan.next();

		switch(sel) {
			case "1" :
				productList();
				break;
			case "2" :
				inputProduct();
				break;
			case "q": System.exit(0);
					break;
		}
	}

//상품 목록을 서버에서 받아와 나타내는 함수
	public void productList() {
		System.out.println("상품 목록 - 상품 선택");
		System.out.println("=========================");

		// 등록된 상품 정보 출력
        try {
            Socket s = new Socket(MainMenu.ip, 5006);
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            BufferedReader br = new BufferedReader((new InputStreamReader(s.getInputStream())));
            pw.println("6");
            int count = 0;
            while(true) {
                String temp = br.readLine();
                if (temp.equals("666")) {
                    s.close();
                    pw.close();
                    br.close();
                    break;
                }
                System.out.println(count + ". " + temp);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

		System.out.println("h : 메인화면");
		System.out.println("c : 체크아웃");
		System.out.print("선택 : ");
		String sel = scan.next();

		// 선택된 메뉴에 따라 처리
		switch(sel) {
			case "h":start();break;
			case "c":checkOut();break;
			default:
				int psel = Integer.parseInt(sel);
				cart.add(psel);
				productList();
		}
	}
//장바구니 확인 및 결제를 진행하는 함수
	public void checkOut() {
		System.out.println("체크아웃");
		System.out.println("=========================");
		if(cart.size() == 0){
		    System.out.println("장바구니에 담긴 물품이 없습니다.");
		    productList();
        }
        Socket s = null;
        try {
            s = new Socket(MainMenu.ip, 5006);
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            BufferedReader br = new BufferedReader((new InputStreamReader(s.getInputStream())));
            pw.println("7");
            for(Integer p : cart) {
                pw.println(p);
                System.out.println(br.readLine());
            }
            pw.println("666");
            System.out.println("금액의 합계는 " + br.readLine() + " 원 입니다.");
            System.out.println("=========================");
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("[p]이전 , [q]결제 완료");
		System.out.print("선택 : ");
		String sel = scan.next();

		switch(sel) {
			case "q":
					System.out.println("## 결제가 완료 되었습니다. 종료합니다 ##");
					System.exit(0);break;
			case "p":productList();break;
			default: checkOut();
		}
	}
//상품을 서버에 등록하는 함수
	private void inputProduct() {
		System.out.printf("상품 이름을 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.printf("상품 가격을 입력해주세요 : ");
		Integer price = sc.nextInt();
        Integer type = null;
		while(true) {
            System.out.printf("상품 타입을 번호로 입력해주세요 (1. 중고제품, 2. 신품 : ");
            type = sc.nextInt();
            if (type != 1 && type != 2)
                System.out.println("상품 타입 입력이 잘못되었습니다. 다시 입력해주세요.");
            else
                break;
        }
		Integer period = null;
		boolean as = false;
		if(type == 1) {
		    System.out.println("실 사용 기간을 입력해 주세요. (개월 단위) : ");
		    period = sc.nextInt();
            System.out.println("AS 가능 여부를 입력해 주세요. (1. AS 가능, 2. AS 불가능 : ");
            if(sc.nextInt() == 1) {
                Socket s = null;
                try {
                    s = new Socket(MainMenu.ip, 5006);
                    PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                    pw.println("5/" + name + "/" + price + "/" + period + "/" + "AS 가능" + ";");
                    s.close();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                Socket s = null;
                try {
                    s = new Socket(MainMenu.ip, 5006);
                    PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                    pw.println("5/" + name + "/" + price + "/" + period + "/" + "AS 불가능" + ";");
                    s.close();
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
		else{
            Socket s = null;
            try {
                s = new Socket(MainMenu.ip, 5006);
                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                pw.println("5/" + name + "/" + price +";");
                s.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("상품 등록이 완료되었습니다. 이전 메뉴로 돌아갑니다.");
        start();
	}
}