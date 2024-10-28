package model;

import baseClass.Person;
import utils.PersonComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Library {
    private HashMap<String, List<Book>> booksOnShelf ;
    private PriorityQueue<Person> personOnQueue = new PriorityQueue<>();
    private List<Person> listForFIFO;

    //Constructor
    public Library() {
        booksOnShelf = new HashMap<>();
        personOnQueue = new PriorityQueue<>(new PersonComparator());
        listForFIFO = new ArrayList<>();
    }

    //Getters
    public HashMap<String,List<Book>> getBooksOnShelf() {
        return booksOnShelf;
    }

    public PriorityQueue<Person> getPersonOnQueue() {
        return personOnQueue;
    }

    public List<Person> getListForFIFO() {
        return listForFIFO;
    }
}
