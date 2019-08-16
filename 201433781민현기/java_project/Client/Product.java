package Client;

public abstract class Product {
    // 상품명과 가격 변수
    String pname;
    int price;
    int point;

    // 상품명과 가격을 출력하는 기본정보 출력 메서드
    public void printDetail() {
        System.out.printf("상품명:%s, 가격:%d, ",pname,price);
        printExtra();
    }

    public abstract void printExtra();
}
