import java.lang.String;
public class OSNameGetter {
    static String os = System.getProperty("os.name", "unknown"); // Not secure, as mentioned by OP

    static {
        System.out.println(os);
    }

    public static void main(String[] args) {
    }
}