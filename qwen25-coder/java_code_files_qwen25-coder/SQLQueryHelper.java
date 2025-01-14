public class SQLQueryHelper {
    class Connection {
        public Statement createStatement(String query) {
            return new Statement();
        }
    }

    class Statement {
    }

    Connection con = new Connection();
    String lastName = "Smith";
    Statement s = con.createStatement("select * from table1 where last_name like '%" + lastName + "%'");

    public static void main(String[] args) {
    }
}