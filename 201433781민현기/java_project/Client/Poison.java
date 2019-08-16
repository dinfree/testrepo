package Client;

public class Poison extends Product {


    public Poison(String pname, int price, int damage){
        this.pname=pname;
        this.price=price;
        this.point=damage;
    }

    @Override
    public void printExtra() {
        System.out.println("효과 "+point+ "만큼 악화\n");
    }
}
