/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main_645 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) throws SQLException, IOException {
        String string = "jdbc:mysql://localhost:3306/your_database";
        String string2 = "your_username";
        String string3 = "your_password";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            connection = DriverManager.getConnection(string, string2, string3);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT field FROM your_table WHERE your_condition");
            if (resultSet.next()) {
                int n;
                Blob blob = resultSet.getBlob("field");
                inputStream = blob.getBinaryStream();
                outputStream = new FileOutputStream("output_file");
                byte[] byArray = new byte[1024];
                while ((n = inputStream.read(byArray)) != -1) {
                    outputStream.write(byArray, 0, n);
                }
            } else {
                System.out.println("No record found.");
            }
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
