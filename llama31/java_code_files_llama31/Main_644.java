/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class Main_644 {
    public static void main(String[] stringArray) {
        String string = "HelloWorld123.";
        if (Pattern.matches("^[a-zA-Z0-9\\.]+$", string)) {
            System.out.println("Input is valid");
        } else {
            System.out.println("Input is not valid");
        }
    }
}
