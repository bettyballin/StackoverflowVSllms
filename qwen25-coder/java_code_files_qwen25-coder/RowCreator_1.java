import java.lang.String;

public class RowCreator_1 {
    private final Object lockingObject = new Object();

    private void createRow(int id) {
        synchronized (lockingObject) {
            Row row = dao().fetch(id);
            if (row == null) {
                dao().create(id);
            }
        }
    }
    
    private Dao dao() {
        return new Dao();
    }

    public static void main(String[] args) {
    }
}

class Row {
}

class Dao {
    public Row fetch(int id) {
        return null;
    }

    public void create(int id) {
    }
}