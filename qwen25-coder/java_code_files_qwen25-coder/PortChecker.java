import java.lang.String;
public class PortChecker {
    public static boolean isValidPort(int port) {
        return port >= 0 && port <= 65535;
    }

    public static void main(String[] args) {
        int testPort = 65535;
        System.out.println("Is the port " + testPort + " valid? " + isValidPort(testPort));
    }
}