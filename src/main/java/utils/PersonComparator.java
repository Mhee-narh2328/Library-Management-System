package utils;

import baseClass.Person;
import enums.Role;


import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getRole().equals(Role.TEACHER) && !(p2.getRole().equals(Role.TEACHER))) {
            return -1;
        } else if (!p1.getRole().equals(Role.TEACHER) && p2.getRole().equals(Role.TEACHER) ) {
            return 1;
        }else if (p1.getRole().equals(Role.SENIOR_STUDENT) && p2.getRole().equals(Role.JUNIOR_STUDENT)) {
            return -1;
        } else if (p1.getRole().equals(Role.JUNIOR_STUDENT) && p2.getRole().equals(Role.SENIOR_STUDENT) ) {
            return 1;
        }
            return 0;


    }

}
