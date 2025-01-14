import static spark.Spark.*;

public class SimpleRestServer {
    public static void main(String[] args) {
        port(8080); // Set the server port

        get("/hello", (req, res) -> "Hello World"); // Define a GET route

        post("/postExample", (request, response) -> {
            String body = request.body();
            return "Received: " + body;
        });
    }
}