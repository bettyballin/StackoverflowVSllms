// Define the custom exception class
class InvalidGpaException extends Exception {
    public InvalidGpaException() {
        super("Invalid GPA. GPA must be between 0.0 and 4.0.");
    }
}

public class Student {
    // Declare the gpa field
    private double gpa;

    // Constructor to initialize the gpa field
    public Student(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        if (gpa >= 0.0 && gpa <= 4.0) {
            return super.toString() + "\n\tGPA: " + gpa;
        } else {
            throw new InvalidGpaException();
        }
    }

    public static void main(String[] args) {
        try {
            Student student = new Student(3.5);
            System.out.println(student.toString());
        } catch (InvalidGpaException e) {
            System.out.println(e.getMessage());
        }
    }
}