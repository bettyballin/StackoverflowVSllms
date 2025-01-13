/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class SetupTokenValidator {
    public static void main(String[] stringArray) {
        String string = UUID.randomUUID().toString();
        String string2 = string;
        if (string2.equals(string)) {
            System.out.println("Token is valid. Allowing configuration...");
        } else {
            System.out.println("Token is invalid. Denying configuration...");
        }
    }
}
