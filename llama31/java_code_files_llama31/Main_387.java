/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_387 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        String string = "your_database_url";
        String string2 = "your_username";
        String string3 = "your_password";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(string, string2, string3);
        }
        catch (SQLException sQLException) {
            System.out.println("Error creating connection: " + sQLException.getMessage());
            return;
        }
        File file = new File("path/to/your/excel/file.xls");
        byte[] byArray = new byte[(int)file.length()];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(byArray);
        }
        catch (IOException iOException) {
            System.out.println("Error reading file: " + iOException.getMessage());
            return;
        }
        finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException iOException) {
                    System.out.println("Error closing file input stream: " + iOException.getMessage());
                }
            }
        }
        String string4 = "UPDATE your_table SET varbinary_column = ? WHERE id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(string4);
            preparedStatement.setBytes(1, byArray);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        }
        catch (SQLException sQLException) {
            System.out.println("Error executing update: " + sQLException.getMessage());
        }
        finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException sQLException) {
                    System.out.println("Error closing prepared statement: " + sQLException.getMessage());
                }
            }
        }
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException sQLException) {
                System.out.println("Error closing connection: " + sQLException.getMessage());
            }
        }
    }
}
