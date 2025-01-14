import java.lang.String;

public class RowCreator {

    private void createRow(int id) {
        try {
            dao().create(id);
        } catch (PrimaryKeyExistsException e) {
            // Handle or ignore as appropriate
        }
    }

    private Dao dao() {
        return new Dao();
    }

    public static void main(String[] args) {
    }
}

class Dao {
    public void create(int id) throws PrimaryKeyExistsException {
        // dummy implementation
    }
}

class PrimaryKeyExistsException extends Exception {
    public PrimaryKeyExistsException() {
        super();
    }
}