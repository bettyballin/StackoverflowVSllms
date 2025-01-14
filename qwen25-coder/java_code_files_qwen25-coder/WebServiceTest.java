import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WebServiceTest {

    @Test
    public void testWebService() {
        // Set base URI for the API
        RestAssured.baseURI = "https://api.example.com";

        // Execute a GET request to the desired endpoint
        Response response = RestAssured.get("/endpoint");

        // Extract and assert information from the response
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Example assertion
        assertEquals(200, statusCode);
    }

    public static void main(String[] args) {
        WebServiceTest test = new WebServiceTest();
        test.testWebService();
    }
}