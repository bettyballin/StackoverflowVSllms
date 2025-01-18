import java.sql.ResultSet;

class DatabaseLayer {
  String connectionString;
  // ...

  void setConnectionString(String connection) {
    // Check if setting is valid before updating, also apply necessary permission checks etc. depending on implementation
    this.connectionString = connection;
  }

  ResultSet callDBProcedure() {
    // Your database interaction methods here
    return null;
  }
}