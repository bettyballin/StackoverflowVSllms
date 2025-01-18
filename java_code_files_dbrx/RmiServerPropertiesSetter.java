import java.lang.String;

public class RmiServerPropertiesSetter {
    static {
        System.setProperty("java.rmi.server.codebase", "http://your-domain.com/path/to/classes/");
    }

    public static void main(String[] args) {
    }
}