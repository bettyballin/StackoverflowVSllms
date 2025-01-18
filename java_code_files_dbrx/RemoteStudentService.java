import java.rmi.RemoteException;

public abstract class RemoteStudentService {
    /**
     * Delete a student on the server
     * @param id The ID of the student to delete
     * @throws RemoteException If there is an error communicating with remote object
     * @throws StudentNotFoundException When the specified student does not exist in the system
     */
    abstract void removeStudent(int id) throws RemoteException, StudentNotFoundException;

    public static void main(String[] args) {
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}