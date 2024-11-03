import enums.Gender;
import enums.Role;
import model.*;
import services.impl.*;

public class Main {
    public static void main(String[] args) {
        //Create instance of book
        Book book1 = new Book(1, "Hafsatu Bebi", "Fatima Bello",2);
        Book book2 = new Book(2, "Broken", "Fatima Bello",2);
        Book book3 = new Book(3, "Twisted Games", "Anna Huang",2);


        LibraryServiceImpl libraryService = new LibraryServiceImpl();
        Library library = new Library();

        libraryService.addBook(book1);
        libraryService.addBook(book2);
        libraryService.addBook(book3);


        //SCENARIO 1 - Where Teacher and Senior Students are asking for the same book,
        // I have 2 copies but the teacher asked for 2 copies so the student doesn't get any

        //Create Instance of Teacher object
        Teacher teacher = new Teacher(1, "uzoma", "Ibezim", Gender.MALE, Role.TEACHER ,2);

        //Create instance for Student object
        Student student = new Student(1, "mheenarh", "Oriyomi", Gender.FEMALE, Role.SENIOR_STUDENT);

        libraryService.addToQueue(student);
        libraryService.addToQueue(teacher);

        System.out.println("*********************************************FIRST SCENARIO *********************************");
        System.out.println(libraryService.giveBook(book1.getBookTitle()));
        System.out.println(libraryService.giveBook(book1.getBookTitle()));

        library.getPersonOnQueue().clear();

        //SCENARIO 2 - Where Junior and Senior Students are asking for the same book.
        Student juniorStudent = new Student(1, "Muminat", "Adefabi", Gender.FEMALE, Role.JUNIOR_STUDENT);
        Student seniorStudent = new Student(2, "Tomilola", "Aturaka", Gender.MALE, Role.SENIOR_STUDENT);

        libraryService.addToQueue(juniorStudent);
        libraryService.addToQueue(seniorStudent);

        System.out.println("*********************************************SECOND SCENARIO *********************************");
        System.out.println(libraryService.giveBook(book2.getBookTitle()));
        System.out.println(libraryService.giveBook(book2.getBookTitle()));

        library.getPersonOnQueue().clear();

        //SCENARIO 3 - FOR IMPLEMENTING FIFO i.e First Come First Serve

        //Instance for Student
        Student juniorStudent2 = new Student(1, "Muminat", "Adefabi", Gender.FEMALE, Role.JUNIOR_STUDENT);
        Student seniorStudent2 = new Student(2, "Tomilola", "Aturaka", Gender.MALE, Role.SENIOR_STUDENT);

        //Instance for Teacher
        Teacher teacher1 = new Teacher(1, "uzoma", "Ibezim", Gender.MALE, Role.TEACHER ,2);

        System.out.println("*********************************************THIRD SCENARIO (FIFO)*********************************");
        libraryService.implementFIFO(juniorStudent2);
        libraryService.implementFIFO(seniorStudent2);
        libraryService.implementFIFO(teacher1);












    }
}
