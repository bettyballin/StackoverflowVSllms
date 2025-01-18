import java.lang.String;

public class EncodingChecker {

    static String encoding = System.getProperty("file.encoding");

    static {
        System.out.println(encoding);
    }

    public static void main(String[] args) {
    }
}