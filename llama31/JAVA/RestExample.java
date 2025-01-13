import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestExample {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://example.com";
        Response response = RestAssured.get("/api/users");
        response.then().statusCode(200);
    }
}