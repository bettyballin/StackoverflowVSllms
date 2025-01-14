import java.lang.String;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ContextUtil {

    static DataSource myDataSource;

    static {
        try {
            InitialContext initialContext = new InitialContext();
            myDataSource = (DataSource) initialContext.lookup("jdbc/MyDataSource");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}