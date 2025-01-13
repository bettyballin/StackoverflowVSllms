import java.lang.String;
import java.rmi.RemoteException;

public class StudentManager_1_1 {
    private void removeStudent(int id) throws RemoteException {
        try {
            // Assuming server is an object of a class that has a removeStudent method
            // You need to initialize or inject this object
            Server server = new Server(); // Replace with your actual server initialization
            server.removeStudent(id);
            System.out.println("Removed student with id: " + id);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // You need to handle RemoteException and create an instance of StudentManager_1
        try {
            StudentManager_1 manager = new StudentManager_1();
            manager.removeStudent(1); // Replace with your actual student id
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Assuming Server class
class Server {
    public void removeStudent(int id) throws StudentNotFoundException {
        // Your implementation to remove student
    }
}

// Assuming StudentNotFoundException class
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}