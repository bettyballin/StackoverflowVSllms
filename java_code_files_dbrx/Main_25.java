import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Example Prize class with simple String text
public class Main {

    public static class Prize implements Serializable {
        private static final long serialVersionUID = 1L;
        public String content;
    }

    public static void main(String[] args) {

        // Assuming 'conn' is your Connection object
        Connection conn = null;

        Prize prizeObject = new Prize();
        prizeObject.content = "some data here";

        // Convert our Java object into a byte array using ByteArrayOutputStream and ObjectOutputStream
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(prizeObject);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Always close both the ObjectOutput stream and the byte array output stream when finished using them
            try {
                if (out != null) out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                bos.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        byte[] yourByteArray = bos.toByteArray();

        // Use a Prepared Statement for inserting BLOB value in SQL query to prevent SQL Injection
        String sql = "INSERT INTO prize_table(prize_column) VALUES (?)";
        try {
            if (conn != null) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setBytes(1, yourByteArray);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}