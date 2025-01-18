// Sample Java code to use middleware for decoupling databases
interface MiddlewareAPI {
    Object getData(String tableName, String columns) throws Exception;
}

public class DataProvider {
    private MiddlewareAPI gateway; // Define interface to interact with a middleware API / Gateway

    public Object getDataFromOtherDatabase(String tableName, String columns) throws Exception {
        return this.gateway.getData(tableName, columns);  // Send request to the service layer for fetching data from other database
    }

    public static void main(String[] args) {
    }
}