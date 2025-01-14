import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddEndpointTest {
    // Testing an API endpoint by hitting it directly
    @Test
    public void testAddEndpoint() {
        given().body("{\"a\": 2, \"b\": 3}")
               .when().post("/add")
               .then().statusCode(200)
               .and().body(equalTo("5"));
    }

    public static void main(String[] args) {
    }
}