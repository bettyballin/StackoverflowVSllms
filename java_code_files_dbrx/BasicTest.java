import java.lang.String;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class BasicTest {
    @Test
    public void verifyGetRequest_IsSuccessful() throws Exception {
        given().
            get("http://localhost:8081/simple-service").
        then().
            statusCode(200).
            body("name", equalTo("Cedric"));
    }

    public static void main(String[] args) {
    }
}