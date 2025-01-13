/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileWriter;
import java.util.Scanner;

public class Main_234 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        String string = "text.txt";
        try (Scanner scanner = new Scanner(System.in);
             FileWriter fileWriter = new FileWriter(string);){
            System.out.println("Enter your name:");
            String string2 = scanner.next();
            fileWriter.write(string2);
        }
    }
}
