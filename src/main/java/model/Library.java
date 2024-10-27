package model;

import baseClass.Person;
import utils.PersonComparator;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Library {
    private HashMap<String, List<Book>> booksOnShelf ;
    private PriorityQueue<Person> personOnQueue = new PriorityQueue<>();

    //Constructor
    public Library() {
        booksOnShelf = new HashMap<>();
        personOnQueue = new PriorityQueue<>(new PersonComparator());
    }

    //Getters
    public HashMap<String,List<Book>> getBooksOnShelf() {
        return booksOnShelf;
    }

    public PriorityQueue<Person> getPersonOnQueue() {
        return personOnQueue;
    }
}
