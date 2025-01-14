import java.lang.String;
// Example of a web service method that requires parameters
class MyWebService {
    public String getDataFromDatabase(String sessionId, String userId) {
        // Use sessionId and userId to fetch data securely
        DatabaseClass db = new DatabaseClass();
        return db.getData(sessionId, userId);
    }
}

// A simple implementation of DatabaseClass
class DatabaseClass {
    public String getData(String sessionId, String userId) {
        // For the purpose of this example, return a dummy string
        return "Data for user " + userId + " with session " + sessionId;
    }
}

// Example of using the service from a client
public class ClientService {
    public void callWebService() {
        MyWebService service = new MyWebService();
        String result = service.getDataFromDatabase("session123", "user456");
        System.out.println(result);
    }

    public static void main(String[] args) {
        ClientService client = new ClientService();
        client.callWebService();
    }
}