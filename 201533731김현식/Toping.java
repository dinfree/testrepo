package Project;

public class Toping extends Product{
		String pluspro;
		
		public Toping(String yname, int price, String pluspro){
			this.yname = yname;
			this.price = price;
			this.pluspro = pluspro;
		}
		
		public void printExtra() {
			System.out.println("추가 제품 : " + pluspro);
		}
	}

