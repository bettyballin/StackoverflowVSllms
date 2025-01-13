import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Define DBConnection class or import it from the correct package
// Assuming it's in the same package for simplicity
class DBConnection {
    private static DBConnection instance;

    private DBConnection() {}

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public java.sql.Connection getConnection() {
        // Implement your database connection logic here
        // For demonstration purposes, assume it's implemented correctly
        return null;
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return getConnection().prepareStatement(query);
    }
}

public class Prize {
    private String type;
    private Object content;

    public Prize(String type, Object content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}

public class PrizeDAO {
    private static String INSERT_PRIZE = "INSERT INTO Prize (id, type, content) VALUES (?, ?, ?)";

    public void save(Prize prize) {
        PreparedStatement ps = null;
        try {
            ps = DBConnection.getInstance().prepareStatement(INSERT_PRIZE);
            ps.setInt(1, 1);
            ps.setString(2, prize.getType());

            if (prize.getContent() instanceof String) {
                ps.setString(3, (String) prize.getContent());
            } else if (prize.getContent() instanceof InputStream) {
                ps.setBinaryStream(3, (InputStream) prize.getContent());
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        Prize prize = new Prize("Test", "This is a test prize");
        PrizeDAO dao = new PrizeDAO();
        dao.save(prize);
    }
}