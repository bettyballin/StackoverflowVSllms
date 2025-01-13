/*
 * Decompiled with CFR 0.152.
 */
import java.util.Scanner;

public class InputSanitizer {
    public static void main(String[] stringArray) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String string2 = string.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(string2);
    }
}
