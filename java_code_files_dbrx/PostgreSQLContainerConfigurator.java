public class PostgreSQLContainerConfigurator {

    @Container
    private PostgreSQLContainer postgres = new PostgreSQLContainer("postgres")
        .withDatabaseName("my-database")
        .withUsername("myusername")
        .withPassword("mypassword");

    // Then the JDBC URL for your application can be configured with -
    String url = postgres.getJdbcUrl();

    public static void main(String[] args) {
    }
}

@interface Container {}

class PostgreSQLContainer {

    public PostgreSQLContainer(String image) {
    }

    public PostgreSQLContainer withDatabaseName(String dbName) {
        return this;
    }

    public PostgreSQLContainer withUsername(String username) {
        return this;
    }

    public PostgreSQLContainer withPassword(String password) {
        return this;
    }

    public String getJdbcUrl() {
        return "";
    }
}