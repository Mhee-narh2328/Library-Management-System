package model;

public class Book {
    private int id;
    private String bookTitle;
    private String bookAuthor;
    private int copies;

    //Constructor
    public Book(int id, String bookTitle, String bookAuthor, int copies) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.copies = copies;
    }

    //Getter

    public int getId() {
        return id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getCopies() {
        return copies;
    }

    //Setters
    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", copies=" + copies +
                '}';
    }
}
