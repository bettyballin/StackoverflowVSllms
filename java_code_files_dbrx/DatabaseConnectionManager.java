import java.lang.String;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    public static void main(String[] args) {
        // Create a new instance of DatabaseConnectionManager and invoke the connect method
        DatabaseConnectionManager manager = new DatabaseConnectionManager();
        manager.connect();
    }

    public void connect() {
        Context ctx = null;
        DataSource ds = null;
        Connection conn = null;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/myDatabase");
            conn = ds.getConnection();
            // use connection for queries and data manipulation
        } catch(Exception e){
            // handle exception
            e.printStackTrace();
        } finally{
            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException ex) { 
                    /* Ignore, as we are closing again */ 
                }
            }
        }
    }
}