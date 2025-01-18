import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyApplication {
    public static void main(String[] args) {
        Connection connection = null; // Initialize your database connection
        String sql = "YOUR SQL QUERY HERE";
        List<MyObject> list = new ArrayList<>();
        int index = 0;
        int indexOfList = 0;

        // Sample data for demonstration purposes
        list.add(new MyObject("Name1", 1));
        list.add(new MyObject("Name2", 2));

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // assuming 'connection' as your db connection object
            for (int i = 1; i <= 2 * list.size();) {
                stmt.setString(i++, list.get(index).getName()); // set the value of column with unique constraint
                stmt.setInt(i++, list.get(indexOfList).counter); // update counter if duplicate entry found
            }
        } catch (SQLException e) {
            // handle exception
            e.printStackTrace();
        }
    }

    static class MyObject {
        private String name;
        public int counter;

        public MyObject(String name, int counter) {
            this.name = name;
            this.counter = counter;
        }

        public String getName() {
            return name;
        }
    }
}