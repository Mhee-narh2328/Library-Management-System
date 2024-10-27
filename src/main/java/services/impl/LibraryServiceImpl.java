package services.impl;

import baseClass.Person;
import enums.Role;
import model.Book;
import model.Library;
import model.Teacher;
import services.LibraryService;

import java.util.*;

public class LibraryServiceImpl implements LibraryService {

    Library library = new Library();
    HashMap<String, List<Book>> bookslist = library.getBooksOnShelf();

    @Override
    public void addBook(Book book) {
        List<Book> bookList = bookslist.get(book.getBookTitle());
        if (bookList == null){
            bookList = new ArrayList<>();
            bookslist.put(book.getBookTitle(),bookList);
        }
        bookList.add(book);
    }

    @Override
    public void addToQueue(Person person) {
        library.getPersonOnQueue().add(person);

    }

    @Override
    public String giveBook(String bookTitle) {
        List<Book> listOfBooks = library.getBooksOnShelf().getOrDefault(bookTitle, new ArrayList<>());

        Queue<Person> queue = library.getPersonOnQueue();

        if (queue.isEmpty()){
            return "No one is in the queue to issue the book";
        }

        Person nextPersonOnQueue = queue.poll();
        String requesterName = nextPersonOnQueue.getFirstName() + " " + nextPersonOnQueue.getLastName();

        if (listOfBooks.isEmpty() || listOfBooks.get(0).getCopies() == 0) {
            return  requesterName + " requested for " +bookTitle + ", but it  has taken because there are 0 copies in the library .";
        }
        Book availableBook = listOfBooks.get(0);

        BookServiceImpl bookService = new BookServiceImpl();

        if (nextPersonOnQueue.getRole().equals(Role.TEACHER)){
            Teacher teacher = (Teacher) nextPersonOnQueue;
            bookService.removeMultipleCopies(availableBook,teacher);
        }else if (nextPersonOnQueue.getRole().equals(Role.SENIOR_STUDENT) || nextPersonOnQueue.getRole().equals(Role.JUNIOR_STUDENT)){
            bookService.removeCopy(availableBook);
        }

        int remainingCopies = availableBook.getCopies();
        return "Book with title: " + bookTitle + " has been given to  " + nextPersonOnQueue.getFirstName() + " " + nextPersonOnQueue.getLastName() +", who is the " + nextPersonOnQueue.getRole() + ", we have " + remainingCopies + " copies left.";


    }



}
