import java.lang.String;

public class OracleDatabaseConnector_4_4 {
    String host = "your_host";
    String port = "your_port";
    String sid = "your_sid";

    String jdbcUrl = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid + "?oracle.jdbc.defaultNChar=true";

    public static void main(String[] args) {
        OracleDatabaseConnector_4 connector = new OracleDatabaseConnector_4();
        System.out.println(connector.jdbcUrl);
    }
}