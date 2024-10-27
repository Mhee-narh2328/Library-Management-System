package model;

import enums.Gender;
import enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    public void studentTest(){
        student = new Student(1, "Muminat", "Adefabi", Gender.FEMALE, Role.JUNIOR_STUDENT);

    }

    @Test
    public void testFirstName(){
        assertEquals("Muminat", student.getFirstName());
    }

    @Test
    public void testLastName(){
        assertEquals("Adefabi", student.getLastName());
    }

    @Test
    public void testGender(){
        assertEquals(Gender.FEMALE, student.getGender());
    }

    @Test
    public void testRole(){
        assertEquals(Role.JUNIOR_STUDENT, student.getRole());
    }


}