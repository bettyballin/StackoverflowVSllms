public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();

        dataSource.setMaximumPoolSize(25); // for example, set desired maximum pool size
        dataSource.setMinimumIdle(10);      // maintain at least this number of idle connections in the pool
        dataSource.setValidationQuery("SELECT 1"); // use this query to validate connection health periodically e.g., on checkout from pool
        dataSource.setConnectionTestQuery("/*ping*/ SELECT 1 FROM DUAL;"); // use this query instead if using Oracle DBMS specifically (more efficient ping operation)
    }

    static class DataSource {
        public void setMaximumPoolSize(int size) {
            // implementation here
        }

        public void setMinimumIdle(int idle) {
            // implementation here
        }

        public void setValidationQuery(String query) {
            // implementation here
        }

        public void setConnectionTestQuery(String query) {
            // implementation here
        }
    }
}