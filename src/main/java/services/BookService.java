package services;

import baseClass.Person;
import model.Book;
import model.Teacher;


public interface BookService {
    void removeCopy(Book book);
    void addCopy(Book book);
    void removeMultipleCopies(Book book, Teacher teacher);
}
