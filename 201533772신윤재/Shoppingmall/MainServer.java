package shoppingmall;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainServer {
    //파일에 저장된 유저를 저장하는 리스트
    public static ArrayList<User> users = new ArrayList<>();
    //파일에 저장된 상품 목록을 저장하는 리스트
    public static ArrayList<Product> products = new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocket sc = new ServerSocket(5006);
            System.out.println("## 서버실행: " + sc.getInetAddress().getLocalHost());
            while (true) {
                Socket s = sc.accept();
                BufferedReader br = new BufferedReader((new InputStreamReader(s.getInputStream())));
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
                String temp = br.readLine();
                System.out.println(temp);
                char menu = temp.charAt(0);
                users.clear();
                products.clear();
                getInfo();
                getProduct();
                switch (menu) {
                    case '1' : System.out.println("로그인 접근");
                        boolean check = false;
                        List<String> templist = Arrays.asList(temp.split("/"));
                        for(int i = 0 ; i < users.size(); i++) {
                            if (users.get(i).getName().equals(templist.get(1)))
                                if (users.get(i).getPass().equals(templist.get(2))) {
                                    System.out.println("성공");
                                    pw.println("성공");
                                    check = true;
                                }
                        }
                        if(!check)
                            pw.println("실패");
                    break;
                    case '2' : System.out.println("회원가입 접근");
                        BufferedWriter writer = new BufferedWriter(new FileWriter("c:/Temp/register.txt", true));
                        writer.write(temp.substring(2));
                        writer.close();
                        break;
                    case '3' : System.out.println("아이디 찾기 접근");
                        boolean checking = false;
                        for (int i = 0; i < users.size(); i++) {
                            if (users.get(i).getPhone().equals(temp.substring(2))) {
                                pw.println("0/" + users.get(i).getName());
                                check = true;
                            }
                        }
                        if(!checking)
                            pw.println("666");
                        break;
                    case '4' : System.out.println("비밀번호 찾기 접근");
                        boolean checks = false;
                        for (int i = 0; i < users.size(); i++) {
                            if (users.get(i).getName().equals(temp.substring(2))) {
                                pw.println("비밀번호 질문 : " + users.get(i).getPassQuestion());
                                if (users.get(i).getPassAnswer().equals(br.readLine())) {
                                    pw.println("비밀번호는 " + users.get(i).getPass() + "입니다.");
                                    checks = true;
                                }
                                else
                                    pw.println("666");
                            }
                        }
                        if(!checks)
                            pw.println("666");
                        break;
                    case '5' :
                        System.out.println("상품 등록 접근");
                        BufferedWriter writers = null;
                        try {
                            writers = new BufferedWriter(new FileWriter("c:/Temp/product.txt", true));
                            writers.write(temp.substring(2));
                            writers.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case '6' :
                        System.out.println("상품 조회 접근");
                        for(int i = 0; i < products.size(); i++) {
                                pw.println(products.get(i).returnString());
                        }
                        pw.println("666");
                        break;
                    case '7' :
                        Integer sum = 0;
                        System.out.println("상품 체크아웃 접근");
                        while(true){
                            Integer tempInt = Integer.parseInt(br.readLine());
                            if(tempInt == 666) {
                                pw.println(sum);
                                break;
                            }
                            pw.println(products.get(tempInt).returnString());
                            sum += products.get(tempInt).price;
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//파일에 저장된 회원 정보를 불러오는 함수
    private static void getInfo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("c:/Temp/register.txt"));
            String fullInfo = reader.readLine();
            List<String> member = Arrays.asList(fullInfo.split(";"));
            for(String string: member){
                List<String> temp = Arrays.asList(string.split("/"));
                users.add(new User(temp.get(0), temp.get(1), temp.get(2), temp.get(3), temp.get(4)));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//파일에 저장된 제품 목록을 불러오는 함수
    private static void getProduct() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("c:/Temp/product.txt"));
            String fullInfo = reader.readLine();
            List<String> product = Arrays.asList(fullInfo.split(";"));
            for(String string: product){
                List<String> temp = Arrays.asList(string.split("/"));
                if(temp.size() == 2)
                    products.add(new New(temp.get(0), Integer.parseInt(temp.get(1))));
                else
                    products.add(new Used(temp.get(0), Integer.parseInt(temp.get(1)), Integer.parseInt(temp.get(2)), temp.get(3)));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
