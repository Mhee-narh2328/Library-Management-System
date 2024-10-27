package services.impl;


import model.Book;
import model.Teacher;
import services.BookService;

public class BookServiceImpl implements BookService {
    int bookLeft;
    @Override
    public void removeCopy(Book book) {
        bookLeft = book.getCopies();
        if (bookLeft > 0){
            book.setCopies(bookLeft -1);
        }

    }

    @Override
    public void addCopy(Book book) {
        bookLeft = book.getCopies();
        bookLeft++;
        book.setCopies(bookLeft);

    }

    @Override
    public void removeMultipleCopies(Book book, Teacher teacher) {
        int copiesToRemove = teacher.getCopiesNeeded(); // Get the number of copies the teacher wants to remove
        int bookLeft = book.getCopies();

        if (copiesToRemove > bookLeft) {
            System.out.println("Not enough copies to remove.");
        } else {
            book.setCopies(bookLeft - copiesToRemove);
        }

    }


}
