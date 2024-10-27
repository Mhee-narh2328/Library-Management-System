package services;

import baseClass.Person;
import model.Book;



public interface LibraryService {
    void addBook(Book book);
    void addToQueue(Person person);
    String giveBook(String bookTitle);

}
