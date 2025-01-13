import java.util.HashMap;
import java.util.Map;

// Define the custom exceptions
class RemoteException extends Exception {
    public RemoteException(String message) {
        super(message);
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

// Define the Student class
class Student {
    int id;

    public Student(int id) {
        this.id = id;
    }
}

public class StudentRegistry {
    // Define the studentList
    private Map<Integer, Student> studentList = new HashMap<>();

    public void removeStudent(int id) throws RemoteException, StudentNotFoundException {
        Student student = studentList.remove(id);

        if (student == null) {
            throw new StudentNotFoundException("Student with id:" + id + " not found in the system");
        }
    }

    public static void main(String[] args) {
    }
}