import java.rmi.RemoteException;

// Define the custom exception
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

public class StudentManager {
    // Implement the removeStudent method
    void removeStudent(int id) throws RemoteException, StudentNotFoundException {
        // Method implementation should be added here
    }

    public static void main(String[] args) {
        // Main method implementation should be added here
    }
}