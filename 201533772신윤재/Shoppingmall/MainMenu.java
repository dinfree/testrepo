package shoppingmall;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    public static String ip = "192.168.152.1";

    public MainMenu() {}

    public void select() {
        System.out.println("## 가천 옥션 쇼핑몰입니다!! ##\n메뉴를 선택해주세요!\n1. 로그인\n2. 회원가입\n3. 아이디 찾기 \n4. 비밀번호 찾기");
        System.out.println("------------------------------------------------------");
        System.out.printf("선택할 메뉴 번호 : ");
        Scanner sc = new Scanner(System.in);
        int selectingMenu = sc.nextInt();
        if(selectingMenu == 1)
            login();
        else if(selectingMenu == 2)
            register();
        else if(selectingMenu == 3)
            findId();
        else if(selectingMenu == 4)
            findPass();
        else {
            System.out.println("잘못된 메뉴번호 입니다. 다시 선택해 주세요.");
            System.out.println("------------------------------------------------------");
            select();
        }
    }
    //로그인 소켓 통신
    private void login() {
        System.out.printf("아이디를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        System.out.printf("비밀번호를 입력해주세요 : ");
        String pass = sc.next();
        try {
            Socket s = new Socket(ip, 5006);
            System.out.println("## 로그인 시도 중...");
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            BufferedReader br = new BufferedReader((new InputStreamReader(s.getInputStream())));
            String msg = "1/" + id +"/" + pass;
            pw.println(msg);
            if(br.readLine().equals("성공"))
            {
                System.out.println("로그인 성공");
                s.close();
                pw.close();
                br.close();
                ShopMenu shop = new ShopMenu();
                shop.start();
                return;
            }
            else{
                System.out.println("아이디나 비밀번호가 잘못되었습니다.");
                login();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //회원가입 소켓 통신
    private void register() {
        System.out.printf("아이디를 입력해주세요 : ");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        System.out.printf("비밀번호를 입력해주세요 : ");
        String pass = sc.next();
        sc.nextLine();
        System.out.println("비밀번호 찾기 질문을 입력해주세요 : ");
        String passQuestion = sc.nextLine();
        System.out.println("비밀번호 찾기 답변을 입력해주세요 : ");
        String passAnswer = sc.nextLine();
        System.out.printf("휴대전화 번호를 입력해 주세요 : ");
        String phone = sc.next();
        try {
            Socket s = new Socket(ip, 5006);
            System.out.println("## 회원가입 시도 중...");
            PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
            String register = id + "/" + pass + "/" + passQuestion + "/" + passAnswer + "/" + phone + ";";
            pw.println("2/"+register);
            System.out.println("회원가입이 완료되었습니다. 메인 메뉴로 돌아갑니다.");
            s.close();
            pw.close();
            select();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //아이디 찾기 소켓 통신
    private void findId() {
        try {
            Socket s = new Socket(ip, 5006);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            BufferedReader br = new BufferedReader((new InputStreamReader(s.getInputStream())));
            System.out.printf("휴대전화 번호를 입력해주세요 : ");
            Scanner sc = new Scanner(System.in);
            String phone = sc.next();
            pw.println("3/"+phone);
            String temp = br.readLine();
            if(!temp.equals("666")) {
                System.out.println("아이디는 : " + temp.substring(2) + "입니다.");
            }
            else
                System.out.println("해당하는 아이디가 없습니다.");
            s.close();
            pw.close();
            br.close();
            select();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //비밀번호 찾기 소켓 통신
    private void findPass() {
        try {
            Socket s = new Socket(ip, 5006);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            BufferedReader br = new BufferedReader((new InputStreamReader(s.getInputStream())));
            System.out.printf("아이디를 입력해주세요 : ");
            Scanner sc = new Scanner(System.in);
            String id = sc.next();
            pw.println("4/"+id);
            String temp = br.readLine();
            if(!temp.equals("666")) {
                System.out.println(temp);
            }
            else {
                System.out.println("해당하는 아이디가 없습니다.");
                select();
            }
            System.out.printf("비밀번호 질문 답변을 입력해주세요 : ");
            String pass = sc.next();
            pw.println(pass);
            temp = br.readLine();
            if(!temp.equals("666")) {
                System.out.println(temp);
            }
            else
                System.out.println("질문에 대한 답변이 잘못되었습니다.");
            s.close();
            pw.close();
            br.close();
            select();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
