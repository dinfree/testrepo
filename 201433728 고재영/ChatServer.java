package JavaProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer extends StoreList{

   public static void main(String[] args) {
      try {
    	 ArrayList<menu> me = new ArrayList<menu>();
         ServerSocket sc = new ServerSocket(5000);
         System.out.println("## 가게오픈: "+sc.getInetAddress().getLocalHost());
         Socket s = sc.accept();
         System.out.println("손님이 입장하였습니다.");
         BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
         PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
         String msg = "";
         
         StoreList store = new StoreList();
         ArrayList<Store> sl = store.getstorelist();
                  
         while(true) {
        	 
				String rl = br.readLine();
				String[] arrRl = rl.split("@");
				msg ="";
				int total = 0;
				int a = 0;
				
				// 주문받은 금액 총합 계산
				if (arrRl[0].equals("order")) {
					for( int i =1 ; i<arrRl.length; i++) {
						a= Integer.parseInt(arrRl[i])-1;
						total += me.get(a).price;
					}									
					
					System.out.printf("총 가격은 %d 입니다.\n",total);
					pw.println("bill@총 가격은 "+total+"원 입니다.");
					pw.flush();
					
				// 주소를 입력받아 가게리스트 전송
				} else if (arrRl[0].equals("add")) {
					System.out.println(arrRl[1]);
					
					msg += "store@";
			         for(int i=0; i<sl.size();i++ ) {
			        	 msg += (i+1)+ ". "+sl.get(i).name +"    "; 
			         }
			         pw.println(msg);
			         pw.flush();
			         
				// 클라이언트가 선택한 메뉴 전송	
				}else if (arrRl[0].equals("store")) {
					a= Integer.parseInt(arrRl[1])-1;
					me = sl.get(a).getmenu();
					
					msg += "menu@";
			         for(int i=0; i<me.size();i++ ) {
			        	 msg += (i+1)+ ". "+me.get(i).product+" : "+me.get(i).price +"원     "; 
			         }
			         pw.println(msg);
			         pw.flush();
				}else if(arrRl[0].equals("list")) {
					msg += "store@";
			         for(int i=0; i<sl.size();i++ ) {
			        	 msg += (i+1)+ ". "+sl.get(i).name+"   "; 
			         }
			         pw.println(msg);
			         pw.flush();
				}
				
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}