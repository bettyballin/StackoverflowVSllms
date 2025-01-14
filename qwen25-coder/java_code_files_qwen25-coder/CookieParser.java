import java.util.regex.*;

public class CookieParser {
    public static void main(String[] args) {
        String cookieHeader = "test_cookie=Cookie+check; path=/; domain=.Site.com";
        String regex = "^([^=]+)=(.*)$";
    
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cookieHeader);
    
        if (matcher.find()) {
            String name = matcher.group(1).trim();
            String value = matcher.group(2).trim();
            System.out.println("Name: " + name);
            System.out.println("Value: " + value);
        }
    }
}