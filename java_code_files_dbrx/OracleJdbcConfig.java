public class OracleJdbcConfig {
    // Use '?' separator for appending properties in oracle thin jdbc driver connection string,
    // Replace '<driver_url>' with actual url you are using without parameters at the end of it.
    String dbUrl = "<driver_url>?oracle.jdbc.timezone=UTC"; // use GMT+0 or other TZ as needed.
    public static void main(String[] args) {
    }
}