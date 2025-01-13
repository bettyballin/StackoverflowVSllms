import java.lang.String;
public class PrintOS {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        System.out.println("Current OS: " + osName);
    }
}