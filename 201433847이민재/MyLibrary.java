import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.io.*;


public class MyLibrary {
     //도서관에 있는 책 리스트
    List<Book> bookList=new LinkedList<>();

    Scanner scan=new Scanner(System.in);

    User curUser; // 현재 로그인한 유저의 정보를 참조하는 참조변수

    public void start(){
        int i=0;
        System.out.println("시작화면 - 작업 선택");
        dash();
        System.out.println("[1]회원 로그인");
        System.out.println("[2]회원가입");
        System.out.println("[-1]종 료");
        dash();
        System.out.print("선택 : ");
        int sel = scan.nextInt();
        System.out.println("## "+sel+"선택 ##");

        cls();
        // 선택된 메뉴에 따라 처리
        switch(sel) {
            case -1: System.exit(0);break;
            case 1: curUser=Login();showMenu();break;
            case 2:Sign_up();start();break;
            default:
                System.out.println("잘못된 입력입니다.");
                showMenu();
                break;
        }
    }

    /*회원가입 함수. 유저에게 이름, 아이디, 비밀번호를 입력받아 파일로 저장.*/
    public void Sign_up(){
        String newId; String newPass; String newName;

        System.out.println("회원가입 화면 - 계정 추가");
        dash();
        System.out.print("이름을 입력하세요: ");
        newName=scan.next();
        System.out.print("새로운 아이디를 입력하세요: ");
        newId=scan.next();
        System.out.print("비밀번호를 입력하세요: ");
        newPass=scan.next();

        try {
            String data=newName+" "+newId+" "+newPass;
            List<String> lst=new ArrayList<>();
            lst.add(data);
            Path fp = Paths.get("./login.txt");
            Files.write(fp, lst,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("회원가입이 완료되었습니다. 처음 화면으로 이동합니다.\n");
    }

   /* 로그인 기능을 구현하는 함수.
    사용자에게 입력받은 id, 비밀번호와 login.txt 파일에 저장된 아이디 비밀번호를 비교.
    일치하면 User 객체 반환*/
    public User Login(){
        System.out.println("로그인화면 - 로그인");
        dash();

        String id; User user=null;
        String pass;
        boolean loginSuccess = false;//로그인 성공 여부
        System.out.print("아이디 입력 : ");
        id =scan.next();
        System.out.print("비밀번호 입력 : ");
        pass =scan.next();
        scan.nextLine();

        try(BufferedReader _input = new BufferedReader(new FileReader("./login.txt"))){
         // try-with-resource문. close 메소드를 알아서 호출해줌

            String s = null;
            while ((s = _input.readLine()) != null){
                String[] split = s.split(" ");
                if(id.equals(split[1]) && pass.equals(split[2])){
                    loginSuccess = true;
                    user=new User(split[0],split[1],split[2]);
                    System.out.println("환영합니다 "+user.getName()+"님!");
                    break;
                }
            }

            if(loginSuccess == false) {
                System.out.print("로그인에 실패했습니다.");
                start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return user;
    }

    /*사용자가 이용 가능한 메뉴를 출력해주는 함수*/
    public void showMenu(){
        cls(); int choice;
        System.out.println("메인화면 - 작업 선택"+"("+curUser.getId()+")");
        dash();
        System.out.println("1.도서 대출\n2.도서 반납\n3.나의 도서 대여 현황\n-1.로그아웃");
        dash();
        System.out.print("선택: ");
        choice=scan.nextInt();

        switch(choice) {
            case -1: cls();start();break;
            case 1: BorrowBook();showMenu();break;
            case 2:returnBook();showMenu();break;
            case 3:curUser.showMyBook();showMenu();break;
        }
    }

    /*사용자가 대여했던 책을 반납해주는 함수*/
    public void returnBook(){
        if(curUser.getMyList().size()==0) {
            System.out.println("현재 대여중인 도서가 없습니다.");
            return;
        }

        int choice;
        System.out.println("\n도서 반납 - 도서 선택"+"("+curUser.getId()+")");

        curUser.showMyBook();
        System.out.print("반납하실 도서의 번호를 입력해주세요(뒤로가기:-1)0:");
        choice=scan.nextInt();
        if(choice==-1)
            return;
        curUser.RemoveBook(choice); // 사용자의 책 대여 목록에서 해당 인덱스의 책 제거
        System.out.println("도서의 반납이 완료되었습니다");
    }

    /*책을 대여하는 함수.
    * 책이 이미 대출중이라면 대출 불가능*/
    public void BorrowBook(){
        System.out.println("\n도서 대출 - 도서 선택"+"("+curUser.getId()+")");
        dash();
        showBookList(); int bookNum;
        dash();
        System.out.print("대출을 원하시는 책의 번호를 입력해주세요(뒤로가기:-1):");
        bookNum=scan.nextInt()-1;
        if(bookNum==-2)
            return;

        Book b=bookList.get(bookNum);

        if (b.getBorrowed())
            System.out.println("##해당 도서는 현재 대출이 불가능합니다##.");

        else {
            curUser.AddBook(b); // 사용자의 대여 목록에 책 추가. 책을 대출중으로 바꿔줌
            b.setBorrowDate(LocalDate.now()); //대여 날짜를 현재 날짜로 설정
            b.setReturnDate(b.getBorrowDate().plusWeeks(2)); //반납 날짜를 현재 날짜 +2주 뒤로 설정
            b.setLastDay(Period.between(b.getBorrowDate(), b.getReturnDate()).getDays()); //반납 까지 남은 날짜 설정
            System.out.println("##대출이 완료되었습니다##");
        }

    }

    /*현재 등록된 책 리스트 출력*/
    public void showBookList(){
        for(int i=0;i<bookList.size();i++){
            System.out.printf("[%d].%s\t,%s\t,%s\t,%s\n",i+1,bookList.get(i).getBookName(),bookList.get(i).getAuthor(),bookList.get(i).getIsbn(),bookList.get(i).isBorrowed());
        }
    }
    /*책 리스트 생성*/
    public void genBook(){
        bookList.add(new Book("반일 종족주의","9788970873268","이영훈"));
        bookList.add(new Book("유럽 도시 기행 1","9788965135586","유시민"));
        bookList.add(new Book("설민석의 한국사 대모험 11","9791188874385","설민석"));
        bookList.add(new Book("유아 식판식","9788952790385","김주연"));
        bookList.add(new Book("90년생이 온다","9791188248674","임홍택"));
        bookList.add(new Book("여행의 이유","9788954655972","김영하"));
        bookList.add(new Book("설민석의 삼국지","9788933870792","설민석"));
        bookList.add(new Book("천년의 질문 1","9788965746829","조정래"));
        bookList.add(new Book("아주 작은 습관의 힘","9791162540640","제임스 클리어"));
        bookList.add(new Book("왜 아이에게 그런 말을 했을까","9791188248919","정재영"));
    }

    public void cls(){
        for(int i=0;i<3;i++)
            System.out.println();
    }

    public static void dash(){
        System.out.println("========================================================================================");
    }
}
