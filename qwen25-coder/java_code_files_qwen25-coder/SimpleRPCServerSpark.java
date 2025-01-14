import static spark.Spark.*;

public class SimpleRPCServerSpark {
    public static void main(String[] args) {
        port(8000);
        post("/rpc", (req, res) -> "This is the response");
    }
}