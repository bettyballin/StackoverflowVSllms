import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ServiceTest {
    public static void main(String[] args) {
        Response response = RestAssured.get("https://api.exmple.com/data");
        System.out.println(response.asString());
    }
}