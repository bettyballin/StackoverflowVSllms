import static io.restassured.RestAssured.*;

public class ExampleUsageOfRestAssuredInJava {
    // Example of using RestAssured in Java
    public static void main(String[] args) {
        given()
            .when()
            .get("https://example.com/api/v1/resource")
            .then()
            .statusCode(200);
    }
}