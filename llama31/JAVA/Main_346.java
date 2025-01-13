// Example of using RESTful API to interact with the proprietary application
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class Main_346 {
    public static void main(String[] args) {
        // Create a REST client
        Client client = ClientBuilder.newClient();

        // Call the proprietary application's API
        Response response = client.target("https://proprietary-app.com/api/data")
                .request(MediaType.APPLICATION_JSON)
                .get();

        // Process the response
        if (response.getStatus() == 200) {
            // Handle successful response
            System.out.println("Successful response");
        } else {
            // Handle error
            System.out.println("Error: " + response.getStatus());
        }
        
        // Close the client to free up resources
        client.close();
    }
}