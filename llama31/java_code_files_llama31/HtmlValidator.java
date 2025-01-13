/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;
import java.util.Set;

public class HtmlValidator {
    private static final Set<String> ALLOWED_ATTRIBUTES = new HashSet<String>();
    private static final Set<String> ALLOWED_STYLES;

    public boolean isValidAttribute(String string, String string2) {
        if (!ALLOWED_ATTRIBUTES.contains(string)) {
            return false;
        }
        if (string.equals("style")) {
            String[] stringArray;
            for (String string3 : stringArray = string2.split(";")) {
                String[] stringArray2 = string3.split(":");
                if (stringArray2.length == 2 && ALLOWED_STYLES.contains(stringArray2[0].trim())) continue;
                return false;
            }
        }
        return true;
    }

    public static void main(String[] stringArray) {
        HtmlValidator htmlValidator = new HtmlValidator();
        System.out.println(htmlValidator.isValidAttribute("style", "color: red; background-color: blue"));
        System.out.println(htmlValidator.isValidAttribute("style", "color: red; invalid-style: blue"));
        System.out.println(htmlValidator.isValidAttribute("href", "https://www.example.com"));
        System.out.println(htmlValidator.isValidAttribute("invalid-attribute", "value"));
    }

    static {
        ALLOWED_ATTRIBUTES.add("style");
        ALLOWED_ATTRIBUTES.add("href");
        ALLOWED_STYLES = new HashSet<String>();
        ALLOWED_STYLES.add("color");
        ALLOWED_STYLES.add("background-color");
    }
}
