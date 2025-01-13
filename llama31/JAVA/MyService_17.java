import java.lang.String;
import javax.sql.DataSource;
import java.sql.Connection;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MyService_17_17 {
    @Autowired
    private DataSource dataSource;

    public void doSomething() throws java.sql.SQLException {
        Connection conn = dataSource.getConnection();
        // use the connection object
    }

	public static void main(String[] args) {
	}
}