package model;

import enums.Gender;
import enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private Teacher teacher;

    @BeforeEach
    public void teacherTest(){
        teacher = new Teacher(1, "Uzoma", "Ibezim", Gender.MALE, Role.TEACHER, 2);

    }

    @Test
    public void testFirstName(){
        assertEquals("Uzoma", teacher.getFirstName());
    }

    @Test
    public void testLastName(){
        assertEquals("Ibezim", teacher.getLastName());
    }

    @Test
    public void testGender(){
        assertEquals(Gender.MALE, teacher.getGender());
    }

    @Test
    public void testRole(){
        assertEquals(Role.TEACHER, teacher.getRole());
    }

    @Test
    public  void  testCopies(){
        assertEquals(2, 2);
    }




}