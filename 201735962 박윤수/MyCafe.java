package cafe;
import java.util.*;

public class MyCafe implements Cafe{
	
	Member[] members = new Member[3];
	Menu[] menus = new Menu[5];
	
	Scanner scan = new Scanner(System.in);

	public void menuList() {
		System.out.println("**카페 Y 메뉴**");
		for(int i = 0 ;i < 5; i++){
			System.out.println(menus[i].getNum()+"  " + menus[i].getName()+"  "+ menus[i].getPrice());
		}
	}
	public void order() {
		String n = null;
		int m_num = 0;
		int price = 0;
		System.out.println("결정하신 메뉴의 번호를 말씀해 주세요");
		String o = scan.next();
		int o2 =Integer.parseInt(o);
		for(int i = 0; i < menus.length; i++) {
			m_num = menus[i].getNum();
			if (o2 == m_num){
				System.out.println(menus[i].getName() + " 한잔" + menus[i].getPrice()+"원 입니다.");
				price = menus[i].getPrice();
				break;
			}
		}
		m_num = m_num-1;
		
		System.out.println("멤버십번호 입력해주세요");
		n = scan.next();
		int n2 =Integer.parseInt(n);
		int p_num = 0;
		int point = 0;
		String pay = null;
		for(int i = 0; i < members.length; i++) {
			p_num = members[i].getPhon_num();
			if (n2 == p_num){
				point = members[i].getPoint();
				System.out.println(point + "포인트 있으십니다.");
				if (point >= price) {
					System.out.println("포인트로 결제 가능하신데 포인트 사용하시겠습니까?");
					System.out.println("[1]포인트 사용");
					System.out.println("[2]카드결제");
					pay = scan.next();
					int p =Integer.parseInt(pay);
					switch(p){
					case 1 : 
						payPoint(point, m_num, i);
						break;
					case 2 :
						payCard(point, m_num, i);
						break;
					}
					
				}else {
					System.out.println("카드결제 도와드리겠습니다.");
					payCard(point, m_num, i);
				}
				break;
			}
		}
		
	}

	public void payPoint(int point, int m_num, int i) {
		point = point - menus[m_num].getPrice();
		members[i].setPoint(point);
		int total = members[i].getPurchaseAmount() + menus[m_num].getPrice();
		members[i].setPurchaseAmount(total);
		Grade g = setGrade(total);
		members[i].setM_garde(g);
		System.out.println("잔여 포인트는 "+point+ ", 멤버십 등급은 "+ g + "입니다.");
		
	}
	public void payCard(int point, int m_num, int i) {
		int add = menus[m_num].getPrice() / 10;
		point = point + add;
		members[i].setPoint(point);
		int total = members[i].getPurchaseAmount() + menus[m_num].getPrice();
		members[i].setPurchaseAmount(total);
		Grade g = setGrade(total);
		members[i].setM_garde(g);
		System.out.println("포인트 적립해서 보유하신 포인트는 "+point+", 멤버십 등급은 "+ g + " 입니다.");
	}
	
	
	public void genMenu() {
		Menu menu = new Menu(1,"아메리카노", 3500);
		menus[0] = menu;
		menu = new Menu(2,"카페라떼", 4000);
		menus[1] = menu;
		menu = new Menu(3,"카페모카", 4500);
		menus[2] = menu;
		menu = new Menu(4,"카라멜마끼아또", 4500);
		menus[3] = menu;
		menu = new Menu(5,"과일스무디", 5500);
		menus[4] = menu;
		
	}
	
	public Grade setGrade(int purchaseAmount) {
		Grade g = null;
		if(purchaseAmount < 100000){
			g = Grade.SILVER;
		}else if(purchaseAmount >= 100000 && purchaseAmount < 200000) {
			g= Grade.GOLD;
		}else {
			g = Grade.PLATINUM;
		}	
	return g;
	}
	public void genMember() {
		Grade g = null;
		
		Member m = new Member(4139, 5700, 198000, Grade.SILVER);
		g = setGrade(m.getPurchaseAmount());
		m.setM_garde(g);
		members[0] = m;
		
		m = new Member(5473, 10800, 240000, Grade.SILVER);
		g = setGrade(m.getPurchaseAmount());
		m.setM_garde(g);
		members[1] = m;
		
		m = new Member(7849, 850, 8000, Grade.SILVER);
		g = setGrade(m.getPurchaseAmount());
		m.setM_garde(g);
		members[2] = m;
	}
	
	public void open() {
		System.out.println("어서오세요 카페 Y입니다.");
		System.out.println("주문하시겠습니까?");
		String sel;
		while(true) {
			System.out.println("[m]메뉴판 보기");
			System.out.println("[o]주문");
			System.out.println("[x]나가기");
			System.out.printf("선택 : ");
			sel = scan.next();
		
			switch(sel) {
			case "o":order();
					break;

			case "m":menuList();
				break;
		
			case "x":
				break;

			default:
				System.out.println("다시 선택해 주세요");
			}
			if(sel.equals("o")) {
				break;
			}else if(sel.equals("x")) {
				break;
			}
		}
	}

}
