package Client;

public class Portion extends Product {


    public Portion(String pname, int price, int heal){
        this.pname=pname;
        this.price=price;
        this.point=heal;
    }

    @Override
    public void printExtra() {
        System.out.println("효과 "+point+ "만큼 회복\n");
    }
}
