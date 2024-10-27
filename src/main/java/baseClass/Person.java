package baseClass;

import enums.Gender;
import enums.Role;


public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Role role;


    // Parameterized Constructor
    public Person(int id, String firstName, String lastName, Gender gender, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.role = role;
    }

    //Getters
    public Gender getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }
}
