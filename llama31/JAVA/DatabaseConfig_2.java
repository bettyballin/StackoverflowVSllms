import java.lang.String;

public class DatabaseConfig_2_2 {
    String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/ORCL?schema=SCOTT";

    public static void main(String[] args) {
        DatabaseConfig_2 dbConfig = new DatabaseConfig_2();
        System.out.println(dbConfig.jdbcUrl);
    }
}