package library;

public abstract class Book {
	protected String bookid;
	protected String subject;
	protected String author;
	protected boolean booking;
	
	public boolean equals(String bookid) {
		if(this.bookid.contentEquals(bookid))
			return true;
		else
			return false;
	}
	
	public abstract int Late(int days);

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isBooking() {
		return booking;
	}

	public void setBooking(boolean booking) {
		this.booking = booking;
	}
	
	
	
}
