/*
 * Decompiled with CFR 0.152.
 */
import java.util.Scanner;

public class MyApp {
    public static void main(String[] stringArray) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your input: ");
        String string = scanner.nextLine();
        System.out.println("You entered: " + string);
        scanner.close();
    }
}
