import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Define RemoteException since it's not imported
class RemoteException extends Exception {
    public RemoteException(String message) {
        super(message);
    }
}

// Exception class definition
class StudentNotFoundException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public StudentNotFoundException(String message) {
        super(message);
    }
}

// Student class definition
class Student {
    private int id;
    private String name;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters (if needed)
    public int getId() { return id; }
    public String getName() { return name; }
}

// Server interface
interface StudentServer {
    /**
     * Delete a student on the server
     *
     * @param id of the student
     * @throws RemoteException if a remote call fails
     * @throws StudentNotFoundException when a student is not found in the system
     */
    void removeStudent(int id) throws RemoteException, StudentNotFoundException;
}

// Server method implementation
class StudentServerImpl implements StudentServer {
    private Map<Integer, Student> studentList = new ConcurrentHashMap<>();

    // Constructor to initialize some students (optional)
    public StudentServerImpl() {
        studentList.put(1, new Student(1, "Alice"));
        studentList.put(2, new Student(2, "Bob"));
    }

    @Override
    public void removeStudent(int id) throws RemoteException, StudentNotFoundException {
        Student student = studentList.remove(id);

        if (student == null) {
            throw new StudentNotFoundException("Student with id:" + id + " not found in the system");
        } else {
            System.out.println("Student with id:" + id + " has been removed.");
        }
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        try {
            StudentServer server = new StudentServerImpl();
            server.removeStudent(1); // Should remove the student
            server.removeStudent(3); // Should throw StudentNotFoundException
        } catch (RemoteException | StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}