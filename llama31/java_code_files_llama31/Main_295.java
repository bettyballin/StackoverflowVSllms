/*
 * Decompiled with CFR 0.152.
 */
import java.io.Console;

public class Main_295 {
    public static void main(String[] stringArray) {
        Console console = System.console();
        if (console != null) {
            String string = new String(console.readPassword("Enter command: ", new Object[0]));
            System.out.println("Output of command goes here");
        } else {
            System.out.println("Console not available");
        }
    }
}
