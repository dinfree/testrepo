package JavaProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
        	
            Socket s = new Socket("127.0.0.1", 5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        	PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
        	Scanner sc = new Scanner(System.in);
        	String in = "";
        	int check=0;
        	
            System.out.println("## 가게 배달서비스입니다.");
            System.out.println("주소를 입력하세요");
    		in = sc.next();
    		pw.println("add@"+in);
        	pw.flush();
        	
        	// 기능 구분
            while(true){
            	
            	String rl = br.readLine();
            	String[] arrRl = rl.split("@");
            	String msg = "";
            	
            	// 주문
            	if(arrRl[0].equals("menu")){
            		msg += "order";
            		System.out.println("## 메뉴를 선택하세요 :");
            		System.out.println(arrRl[1]);
            		System.out.println("주문하세요");
            		
            		// 기능선택
            		while(true) {
            			in = sc.next();
            			
            			// 주문완료
            			if(in.equals("e")) {
            				break;
            				
            			// 주문초기화
            			}else if(in.equals("r")){
            				msg ="order";
            				System.out.println("다시 주문하세요.");
            				
            			// 뒤로가기(가게를 다시 선택)
            			}else if(in.equals("s")){
            				msg ="list@";
            				break;
            			}
            			else{
            				msg = msg + "@" + in;
            				System.out.println("추가주문이 없으시면 e를, 주문 초기화는 r을, 가게선택은 s를 눌러주세요. ");
            			}  			
            			
            		}
         
                
                // 총 금액
            	}else if(arrRl[0].equals("bill")){
            		System.out.println(rl.split("@")[1]);
            		check=1;
            		
            	// 가게 선택
            	}else if(arrRl[0].equals("store")){
            		System.out.println("## 가게를 선택하세요: " + arrRl[1]);
            		in = sc.next();
            		msg =msg + "store@"+in;
            	}
            	
            	pw.println(msg);
            	pw.flush();
            	
                if(check==1){
                	System.out.println("조금만 기다려주세요.");
                }
            }
           
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
