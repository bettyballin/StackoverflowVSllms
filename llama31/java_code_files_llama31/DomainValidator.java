/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DomainValidator {
    private static final Pattern AU_DOMAIN_PATTERN = Pattern.compile("^[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.(com|net|org|biz)\\.au$");

    public static boolean isValidAUDomain(String string) {
        Matcher matcher = AU_DOMAIN_PATTERN.matcher(string);
        return matcher.matches();
    }

    public static void main(String[] stringArray) {
        System.out.println(DomainValidator.isValidAUDomain("xxx.com.au"));
        System.out.println(DomainValidator.isValidAUDomain("xxx.net.au"));
        System.out.println(DomainValidator.isValidAUDomain("xxx.org.au"));
        System.out.println(DomainValidator.isValidAUDomain("xxx.biz.au"));
        System.out.println(DomainValidator.isValidAUDomain("xxx.--.au"));
    }
}
