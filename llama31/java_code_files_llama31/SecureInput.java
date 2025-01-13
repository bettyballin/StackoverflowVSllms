/*
 * Decompiled with CFR 0.152.
 */
import java.io.Console;

public class SecureInput {
    public static void main(String[] stringArray) {
        Console console = System.console();
        if (console != null) {
            char[] cArray = console.readPassword("Enter password: ", new Object[0]);
        } else {
            System.out.println("Console not available");
        }
    }
}
