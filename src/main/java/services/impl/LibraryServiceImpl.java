package services.impl;

import baseClass.Person;
import enums.Role;
import model.Book;
import model.Library;
import model.Teacher;
import services.LibraryService;

import java.util.*;

public class LibraryServiceImpl implements LibraryService {

    private final Library library = new Library();
    private final Map<String, List<Book>> bookslist = library.getBooksOnShelf();

    @Override
    public void addBook(Book book) {
        bookslist.computeIfAbsent(book.getBookTitle(), title -> new ArrayList<>()).add(book);
    }

    @Override
    public void addToQueue(Person person) {
        library.getPersonOnQueue().add(person);
    }

    @Override
    public String giveBook(String bookTitle) {
        if (library.getPersonOnQueue().isEmpty()) {
            return "No one is in the queue to issue the book";
        }

        Person nextPersonOnQueue = library.getPersonOnQueue().poll();
        List<Book> listOfBooks = getBooksForTitle(bookTitle);

        if (listOfBooks.isEmpty() || listOfBooks.get(0).getCopies() == 0) {
            return generateOutOfStockMessage(bookTitle, nextPersonOnQueue);
        }

        Book availableBook = listOfBooks.get(0);
        processBookRequest(availableBook, nextPersonOnQueue);
        return generateSuccessMessage(bookTitle, availableBook, nextPersonOnQueue);
    }

    @Override
    public void implementFIFO(Person person) {
        addToQueue(person);
        System.out.println(generateFIFOMessage(person) + " has been added to the queue.");
    }

    // Helper methods
    private List<Book> getBooksForTitle(String bookTitle) {
        return bookslist.getOrDefault(bookTitle, new ArrayList<>());
    }

    private String generateOutOfStockMessage(String bookTitle, Person person) {
        return String.format("%s %s who is a %s requested for %s, but it is unavailable due to zero copies in the library.",
                person.getFirstName(), person.getLastName(), person.getRole(), bookTitle);
    }

    private void processBookRequest(Book book, Person person) {
        BookServiceImpl bookService = new BookServiceImpl();

        if (person.getRole() == Role.TEACHER) {
            bookService.removeMultipleCopies(book, (Teacher) person);
        } else if (EnumSet.of(Role.SENIOR_STUDENT, Role.JUNIOR_STUDENT).contains(person.getRole())) {
            bookService.removeCopy(book);
        }
    }

    private String generateSuccessMessage(String bookTitle, Book book, Person person) {
        return String.format("Book with title: %s has been given to %s %s, who is a %s. We have %d copies left.",
                bookTitle, person.getFirstName(), person.getLastName(), person.getRole(), book.getCopies());
    }

    private String generateFIFOMessage(Person person) {
        return String.format("%s %s, who is a %s, is being attended to.",
                person.getFirstName(), person.getLastName(), person.getRole());
    }
}
