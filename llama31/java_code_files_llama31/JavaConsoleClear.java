/*
 * Decompiled with CFR 0.152.
 */
public class JavaConsoleClear {
    public static void clearConsole() {
        System.out.print("\u001b[2J");
        System.out.flush();
    }

    public static void main(String[] stringArray) {
        for (int i = 0; i < 10; ++i) {
            System.out.println("Message " + i);
        }
        JavaConsoleClear.clearConsole();
    }
}
