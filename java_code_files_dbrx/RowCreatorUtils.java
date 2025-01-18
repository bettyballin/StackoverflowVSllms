public class RowCreatorUtils {
    private void createRow(int id) {
        Row row = null;
        synchronized (TestClass.class) {
            row = dao().fetch(id);
            if (row == null) {
                row = dao().create(id);
            }
        }
    }

    private Dao dao() {
        return new Dao();
    }

    class Row {
    }

    static class TestClass {
    }

    class Dao {
        public Row fetch(int id) {
            return null;
        }
        public Row create(int id) {
            return null;
        }
    }

    public static void main(String[] args) {
    }
}