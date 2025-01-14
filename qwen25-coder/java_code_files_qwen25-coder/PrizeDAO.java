import java.io.*;
import java.sql.*;

public class PrizeDAO {
    private Connection connection;

    public PrizeDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertPrize(Prize prize, String prizeName) throws SQLException, IOException {
        // Serialize the Prize object to a byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(prize);
        oos.close();
        byte[] prizeBytes = baos.toByteArray();

        // Insert the serialized object into the database
        String sql = "INSERT INTO PRIZES (NAME, CONTENT) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, prizeName);
            ps.setBytes(2, prizeBytes);
            ps.executeUpdate();
        }
    }

    // Additional methods for reading and manipulating Prize objects can be added here

    public static void main(String[] args) {
    }
}

// Minimal Prize class definition
class Prize implements Serializable {
    // Define fields and methods as necessary
}