package model;

import baseClass.Person;
import enums.Gender;
import enums.Role;

public class Teacher extends Person {
    private int copiesNeeded;


    //Constructor

    public Teacher(int id, String firstName, String lastName, Gender gender, Role role, int copiesNeeded) {
        super(id, firstName, lastName, gender, role);
        this.copiesNeeded = copiesNeeded;
    }

    //Getter

    public int getCopiesNeeded() {
        return copiesNeeded;
    }

    public void setCopiesNeeded(int copiesNeeded) {
        this.copiesNeeded = copiesNeeded;
    }
}
