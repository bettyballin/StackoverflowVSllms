import java.lang.String;
import java.rmi.RemoteException;

public class StudentController {
    private Server server;

    private void removeStudent(int id) {
        try {
            server.removeStudent(id);
            System.out.println("Removed student with ID " + id);
        } catch (RemoteException e) {
            // Handle exception related to network I/O errors
            e.printStackTrace(); // Or add your own logic to handle this type of error
        } catch (StudentNotFoundException e) {
            // Handle exception when student does not exist in the system
            System.out.println(e.getMessage()); // Or add your own logic to handle this type of error
        }
    }

    public static void main(String[] args) {
    }

    // Exception class for handling student not found scenarios
    public static class StudentNotFoundException extends Exception {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }

    // Interface representing the server with the removeStudent method
    public interface Server {
        void removeStudent(int id) throws RemoteException, StudentNotFoundException;
    }
}