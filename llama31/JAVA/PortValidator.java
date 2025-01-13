public class PortValidator {
    public boolean isValidPort(int port) {
        return port >= 0 && port <= 65535;
    }
    public static void main(String[] args) {
        PortValidator validator = new PortValidator();
        System.out.println(validator.isValidPort(8080));  // prints: true
        System.out.println(validator.isValidPort(-1));    // prints: false
        System.out.println(validator.isValidPort(65536)); // prints: false
    }
}