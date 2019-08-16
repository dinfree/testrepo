import java.time.LocalDate;


public class Book {
    private String bookName;
    private String isbn;
    private String author;
    private boolean borrowed;

    private LocalDate borrowDate;
    private LocalDate returnDate;
    private int lastDay;

    public Book(String n,String i,String a){
        bookName=n;
        isbn=i;
        author=a;
        borrowed=false;

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String isBorrowed(){
        if(borrowed==true){
            return "대출불가";
        }
        else
            return "대출가능";
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public boolean getBorrowed(){return borrowed;}

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setLastDay(int lastDay) {
        this.lastDay = lastDay;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getLastDay() {
        return lastDay;
    }
}
