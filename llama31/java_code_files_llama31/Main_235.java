/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileWriter;
import java.util.Scanner;

public class Main_235 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        if (stringArray.length != 1) {
            System.out.println("Usage: java Main <filename>");
            System.exit(1);
        }
        String string = stringArray[0];
        try (Scanner scanner = new Scanner(System.in);
             FileWriter fileWriter = new FileWriter(string);){
            System.out.println("Enter your name:");
            String string2 = scanner.next();
            fileWriter.write(string2);
        }
    }
}
