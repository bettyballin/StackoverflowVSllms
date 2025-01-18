import java.util.*;

class InvalidGpaException extends Exception {
    public InvalidGpaException(String message) {
        super(message);
    }
}

class Person {
    // Base class implementation (can be empty or include common attributes/methods)
}

public class Student extends Person {
    private double gpa;

    public void setGPA(double gpa) throws InvalidGpaException {
        if (gpa < 0 || gpa > 4) {
            throw new InvalidGpaException("Invalid GPA: " + gpa); // Exception handling here.
        } else {
            this.gpa = gpa;
        }
    }

    // You can now set the GPA inside your loop before invoking toString(),
    // thus preventing duplicate messages and encapsulating GPA validation in one place.

    @Override
    public String toString() {
        return "GPA: " + gpa;
    }

    public static void main(String[] args) {
        Student student = new Student();
        try {
            student.setGPA(3.5);
            System.out.println(student);
        } catch (InvalidGpaException e) {
            System.out.println(e.getMessage());
        }
    }
}