import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MyTest_17_17 {
    public void testGetUser() {
        Response response = RestAssured.get("https://api.example.com/users/1");
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("John Doe", response.jsonPath().getString("name"));
    }

    public static void main(String[] args) {
        MyTest_17 test = new MyTest_17();
        test.testGetUser();
    }
}