package Client;


public class RandomDrink extends Product {

    RandomDrink(int price){
        this.price=price;
        point=0;
        pname="알수 없는 물약";
    }

    @Override
    public void printExtra() {
        if(point<0){
            System.out.println("효과 "+point+ "만큼 악화\n");
        }else if(point==0){
            System.out.println("??\n");

        }else if(point >0){
            System.out.println("효과 "+point+ "만큼 회복\n");
        }

    }
}
