package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class GameServer {
    public static void main(String[] args) {
        String msg;

        try {
            ServerSocket ssc=new ServerSocket(5005);
            System.out.println("## 서버 실행: " +ssc.getInetAddress().getLocalHost());


            while(true) {

                Socket s=ssc.accept();
                BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter wr=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
               // BufferedWriter writer=new BufferedWriter(new FileWriter("/Users/hyeon/Documents/Temp/Serverlog.txt")); //로그 기록(윈도우 서버)
                BufferedWriter writer=new BufferedWriter(new FileWriter("C:/Temp/log.txt",true)); //로그 기록 (맥북 서버)


                System.out.println("## 클라이언트 연결됨!!");
                String notice="<공지>게임 세상에 오신것을 환영합니다\n";


                wr.println(notice);

                while ((msg=br.readLine())!="exit"){

                    if(msg==null){
                       break;
                    }else {
                        System.out.println(msg);
                        writer.newLine();
                        writer.write(msg);
                        writer.flush();
                    }

                }
                System.out.println("\n게임을 종료하였습니다.\n");
                writer.write("         게임을 종료하였습니다\n");
                writer.write("=======================================");
                writer.flush();
                br.close();
                wr.close();
                writer.close();


            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
