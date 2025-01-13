import com.zaxxer.hikari.HikariDataSource;

public class DatabaseConfigurator {
    public static void main(String[] args) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
        ds.setUsername("myuser");
        ds.setPassword("mypassword");
        ds.setMaximumPoolSize(10);
    }
}