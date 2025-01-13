/*
 * Decompiled with CFR 0.152.
 */
public class ConsoleFormatter {
    public static void printSpaces(int n) {
        System.out.print(String.format("%" + n + "s", ""));
    }

    public static void main(String[] stringArray) {
        ConsoleFormatter.printSpaces(5);
    }
}
