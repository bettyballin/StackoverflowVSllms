import java.lang.String;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerCounterDao {
    private PreparedStatement prepStatement;
    private Connection connection;
    private int movieId;
    private String state;

    public CustomerCounterDao(Connection connection, int movieId, String state) throws SQLException {
        this.connection = connection;
        this.movieId = movieId;
        this.state = state;

        prepStatement = connection.prepareStatement("SELECT COUNT(*) AS numCustomers FROM ( SELECT DISTINCT CUSTOMER_ID FROM RENTS WHERE movie_id = ? ) c_id JOIN CUSTOMER ON c_id.CUSTOMER_ID = CUSTOMER.custumerID AND state = ?");
        prepStatement.setInt(1, movieId); // or set whatever you are comparing here i.e., String,Long...
        prepStatement.setString(2, state);
        prepStatement.executeQuery();
    }

    public static void main(String[] args) {
    }
}