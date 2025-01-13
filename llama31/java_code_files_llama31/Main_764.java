/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_764 {
    public static void main(String[] stringArray) {
        String[][] stringArrayArray = new String[][]{{"val1", "val2", "val3"}, {"val4", "val5", "val6"}};
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "youruser", "yourpassword");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO myData (col1, col2, col3) VALUES (?, ?, ?)");
            for (String[] stringArray2 : stringArrayArray) {
                preparedStatement.setString(1, stringArray2[0]);
                preparedStatement.setString(2, stringArray2[1]);
                preparedStatement.setString(3, stringArray2[2]);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement = connection.prepareStatement("UPDATE mytable m SET m.col3 = d.col3 FROM mytable m INNER JOIN myData d ON m.col1 = d.col1 AND m.col2 = d.col2");
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.out.println("Error: " + sQLException.getMessage());
        }
    }
}
