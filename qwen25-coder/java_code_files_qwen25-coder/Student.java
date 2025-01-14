import java.util.Scanner;

public class Student extends Person {
    private double gpa;

    public Student() {
        super();
        gpa = 0.0;
    }

    public Student(String firstName, String lastName, double gpa) {
        super(firstName, lastName);
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        try {
            if (gpa >= 0.0 && gpa <= 4.0) {
                return super.toString() + "\n\tGPA: " + gpa;
            } else {
                throw new InvalidGpaException();
            }
        } catch (InvalidGpaException e) {
            // Removed the print statement as instructed
            // System.out.println(e);
            return super.toString() + "\n\tGPA: " + gpa;
        }
    }

    public void display() {
        System.out.println("<<Student>>" + this);
    }

    @Override
    public void input(Scanner in) {
        super.input(in);

        if (in.hasNextDouble()) {
            this.gpa = in.nextDouble();
        }
    }

    class InvalidGpaException extends Exception {
        public InvalidGpaException() {
            super("Invalid GPA: " + gpa);
        }
    }

    public static void main(String[] args) {
        // Main method can be used for testing
    }
}

// Assuming the Person class is defined as follows
class Person {
    private String firstName;
    private String lastName;

    public Person() {
        firstName = "";
        lastName = "";
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void input(Scanner in) {
        if (in.hasNextLine()) {
            this.firstName = in.nextLine();
        }
        if (in.hasNextLine()) {
            this.lastName = in.nextLine();
        }
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName;
    }
}