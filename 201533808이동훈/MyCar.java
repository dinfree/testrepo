package Project;

import java.util.ArrayList;
import java.util.Scanner;


public class MyCar implements IShop{
	   
	   User[] users = new User[2];
	   
	   Car[] cars = new Car[6];
	   
	   ArrayList<Car> cart = new ArrayList<Car>();
	      
	   Scanner scan = new Scanner(System.in);
	   
	   int selUser;
	   
	   String title;
	   
	   public void setTitle(String title) {
	      this.title = title;
	   }
	   
	   public void start() {
	      System.out.println(title+" : 구매자 선택");
	      System.out.println("========================");
	      int i=0;
	      
	      for(User u : users) {
	         System.out.printf("[%d]%s(%s)\n",i++,u.getName(),u.getPayType());
	      }
	      
	      System.out.println("[x]종 료");
	      System.out.print("선택 : ");
	      String sel = scan.next();
	      System.out.println("## "+sel+"선택 ##");
	      
	      switch(sel) {
	         case "x": System.exit(0);break;
	         default:
	            selUser = Integer.parseInt(sel);
	            carList();
	      }
	   }
	   
	   public void carList() {
	      System.out.println(title+" : 차 목록 - 차 선택");
	      System.out.println("=========================");
	      int i=0;
	      
	      for(Car c : cars) {
	         System.out.print("["+i+"]");
	         c.printDetail();
	         i++;
	      }
	      System.out.println("[h]메인화면");
	      System.out.println("[c]체크아웃");
	      System.out.print("선택 : ");
	      String sel = scan.next();
	      System.out.println("## "+sel+"선택 ##");

	      switch(sel) {
	         case "h":start();break;
	         case "c":checkOut();break;
	         default:
	            int psel = Integer.parseInt(sel);
	            cart.add(cars[psel]);
	            carList();
	      }
	   }
	   
	   public void checkOut() {
	      System.out.println(title+" : 체크아웃");
	      System.out.println("=========================");
	      int total=0;
	      int i=0;
	      
	      for(Car c : cart) {
	         System.out.printf("[%d]%s(%s)\n",i++,c.cname,c.price);
	         total = total + c.price;
	      }
	      System.out.println("=========================");
	      
	      System.out.println("결제 방법: "+users[selUser].getPayType());

	      System.out.println("합계: "+total+" 원 입니다.");
	      System.out.println("[p]이전 , [q]결제 완료");
	      System.out.print("선택 : ");
	      String sel = scan.next();

	      switch(sel) {
	         case "q":
	               System.out.println("## 결제가 완료 되었습니다. 종료합니다 ##");
	               System.exit(0);break;
	         case "p":carList();break;
	         default: checkOut();
	      }      
	   }
	   
	   public void genUser() {
	      User user = new User("이동훈",PayType.LEASE);
	      users[0] = user;
	      user = new User("김동훈",PayType.INSTALLMENT);
	      users[1] = user;
	   }

	   public void genCar() {
	      Sedan sd = new Sedan("그랜져",30000000,"14");
	      cars[0] = sd;
	      sd = new Sedan("E-Class",70000000,"12");
	      cars[1] = sd;
	      Suv sv = new Suv("모하비",40000000,"40");
	      cars[2] = sv;
	      sv = new Suv("에스칼레이드",130000000,"62");
	      cars[3] = sv;
	      SportsCar sc = new SportsCar("머스탱2.3",50000000,"300");
	      cars[4] = sc;
	      sc = new SportsCar("머스탱5.0",65000000,"450");
	      cars[5] = sc;
	   }
	}