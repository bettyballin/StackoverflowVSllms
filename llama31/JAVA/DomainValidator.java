import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DomainValidator {
    private static final Pattern AU_DOMAIN_PATTERN = Pattern.compile("^[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.(com|net|org|biz)\\.au$");

    public static boolean isValidAUDomain(String domain) {
        Matcher matcher = AU_DOMAIN_PATTERN.matcher(domain);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidAUDomain("xxx.com.au")); // true
        System.out.println(isValidAUDomain("xxx.net.au")); // true
        System.out.println(isValidAUDomain("xxx.org.au")); // true
        System.out.println(isValidAUDomain("xxx.biz.au")); // true
        System.out.println(isValidAUDomain("xxx.--.au")); // false
    }
}