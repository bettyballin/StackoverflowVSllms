import java.lang.String;

public class HelloWorldRunner {
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        HelloWorldRunner runner = new HelloWorldRunner();
        runner.run();
    }
}