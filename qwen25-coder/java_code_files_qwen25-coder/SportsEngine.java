import java.lang.String;
public class Main {
    // Example: Car and Engine variations
    interface Engine {}
    class SportsEngine implements Engine{}
    class HybridEngine implements Engine{}

    abstract class Car {
        Engine engine;
    }

    public static void main(String[] args) {
    }
}