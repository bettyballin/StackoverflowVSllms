import java.lang.String;
public class UrlValidator {
    public static boolean isUrl(String location) {
        try {
            new java.net.URL(location).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) {
    }
}