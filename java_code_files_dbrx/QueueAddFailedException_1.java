public interface MyAccountService {
    void create(String user) throws QueueAddFailedException; // list other possible exceptions here
}

class QueueAddFailedException extends Exception {
    // Exception definition here
    public QueueAddFailedException() {
        super();
    }

    public QueueAddFailedException(String message) {
        super(message);
    }
}