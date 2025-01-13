import spark.Spark;

public class HelloWorld_26_26 {
    public static void main(String[] args) {
        Spark.get("/hello", (req, res) -> "Hello World!");
    }
}