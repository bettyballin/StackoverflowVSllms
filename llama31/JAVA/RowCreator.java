import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class RowCreator {
    private final Lock lock = new ReentrantLock();

    private void createRow(int id) {
        lock.lock();
        try {
            Row row = dao().fetch(id);
            if (row == null) {
                dao().create(id);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
    }

    // Assuming dao() and Row class are defined somewhere in your codebase
    // If not, you'll need to define them or import the correct classes
    private Row dao() {
        // implementation of dao() method
        return null;
    }

    private class Row {
        // implementation of Row class
    }
}