public class MyAccountServiceImpl implements MyAccountService {
    public void create(String user) throws QueueAddFailedException { // list other possible exceptions here.
        try {
            Message message = new Message(user);
            addToQueue(message);
        } catch (RuntimeException e) {
            throw new QueueAddFailedException("Error while adding message to queue for user " + user + ".", e);
        }
        // Repeat above pattern for all operations you want to monitor.
    }

    private void addToQueue(Message message) {
        // Implementation here
    }
}

interface MyAccountService {
    void create(String user) throws QueueAddFailedException;
}

class Message {
    private String user;

    public Message(String user) {
        this.user = user;
    }

    // getters and setters
}

class QueueAddFailedException extends Exception {
    public QueueAddFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}