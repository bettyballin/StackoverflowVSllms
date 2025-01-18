// create an interface for the database connector
interface DBConnector {
  int getDimension(String dimensionName, int otherID);
  // define methods here to interact with your real DB connection
}

class MyService {
    private DBConnector conn;

    public MyService(DBConnector conn) {
        this.conn = conn;
    }

    void doSomething() {
      int otherID = 0; // example value
      int alt = conn.getDimension("alt", otherID);
      int str = conn.getDimension("str", otherID);
      // ....
    }
}