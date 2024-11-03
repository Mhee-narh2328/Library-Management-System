package services.impl;


import model.Book;
import model.Teacher;
import services.BookService;

public class BookServiceImpl implements BookService {
    @Override
    public void removeCopy(Book book) {
        updateBookCopies(book, -1);

    }

    @Override
    public void addCopy(Book book) {
        updateBookCopies(book, 1);

    }

    @Override
    public void removeMultipleCopies(Book book, Teacher teacher) {
        int copiesToRemove = teacher.getCopiesNeeded();
        if (canRemoveCopies(book, copiesToRemove)) {
            updateBookCopies(book, -copiesToRemove);
        } else {
            System.out.println("Not enough copies to remove.");
        }

    }

    private void updateBookCopies(Book book, int change) {
        int newCount = book.getCopies() + change;
        book.setCopies(Math.max(newCount, 0));
    }

    private boolean canRemoveCopies(Book book, int copiesToRemove) {
        return book.getCopies() >= copiesToRemove;
    }


}
