package cafe;
import java.util.*;

public class MyCafe implements Cafe{
	
	Member[] members = new Member[3];
	Menu[] menus = new Menu[5];
	
	Scanner scan = new Scanner(System.in);

	public void menuList() {
		System.out.println("**ī�� Y �޴�**");
		for(int i = 0 ;i < 5; i++){
			System.out.println(menus[i].getNum()+"  " + menus[i].getName()+"  "+ menus[i].getPrice());
		}
	}
	public void order() {
		String n = null;
		int m_num = 0;
		int price = 0;
		System.out.println("�����Ͻ� �޴��� ��ȣ�� ������ �ּ���");
		String o = scan.next();
		int o2 =Integer.parseInt(o);
		for(int i = 0; i < menus.length; i++) {
			m_num = menus[i].getNum();
			if (o2 == m_num){
				System.out.println(menus[i].getName() + " ����" + menus[i].getPrice()+"�� �Դϴ�.");
				price = menus[i].getPrice();
				break;
			}
		}
		m_num = m_num-1;
		
		System.out.println("����ʹ�ȣ �Է����ּ���");
		n = scan.next();
		int n2 =Integer.parseInt(n);
		int p_num = 0;
		int point = 0;
		String pay = null;
		for(int i = 0; i < members.length; i++) {
			p_num = members[i].getPhon_num();
			if (n2 == p_num){
				point = members[i].getPoint();
				System.out.println(point + "����Ʈ �����ʴϴ�.");
				if (point >= price) {
					System.out.println("����Ʈ�� ���� �����Ͻŵ� ����Ʈ ����Ͻðڽ��ϱ�?");
					System.out.println("[1]����Ʈ ���");
					System.out.println("[2]ī�����");
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
					System.out.println("ī����� ���͵帮�ڽ��ϴ�.");
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
		System.out.println("�ܿ� ����Ʈ�� "+point+ ", ����� ����� "+ g + "�Դϴ�.");
		
	}
	public void payCard(int point, int m_num, int i) {
		int add = menus[m_num].getPrice() / 10;
		point = point + add;
		members[i].setPoint(point);
		int total = members[i].getPurchaseAmount() + menus[m_num].getPrice();
		members[i].setPurchaseAmount(total);
		Grade g = setGrade(total);
		members[i].setM_garde(g);
		System.out.println("����Ʈ �����ؼ� �����Ͻ� ����Ʈ�� "+point+", ����� ����� "+ g + " �Դϴ�.");
	}
	
	
	public void genMenu() {
		Menu menu = new Menu(1,"�Ƹ޸�ī��", 3500);
		menus[0] = menu;
		menu = new Menu(2,"ī���", 4000);
		menus[1] = menu;
		menu = new Menu(3,"ī���ī", 4500);
		menus[2] = menu;
		menu = new Menu(4,"ī��Ḷ���ƶ�", 4500);
		menus[3] = menu;
		menu = new Menu(5,"���Ͻ�����", 5500);
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
		System.out.println("������� ī�� Y�Դϴ�.");
		System.out.println("�ֹ��Ͻðڽ��ϱ�?");
		String sel;
		while(true) {
			System.out.println("[m]�޴��� ����");
			System.out.println("[o]�ֹ�");
			System.out.println("[x]������");
			System.out.printf("���� : ");
			sel = scan.next();
		
			switch(sel) {
			case "o":order();
					break;

			case "m":menuList();
				break;
		
			case "x":
				break;

			default:
				System.out.println("�ٽ� ������ �ּ���");
			}
			if(sel.equals("o")) {
				break;
			}else if(sel.equals("x")) {
				break;
			}
		}
	}

}
