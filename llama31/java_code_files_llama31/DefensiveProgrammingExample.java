/*
 * Decompiled with CFR 0.152.
 */
public class DefensiveProgrammingExample {
    public static void main(String[] stringArray) {
        String string = DefensiveProgrammingExample.getInputFromUser();
        if (string == null || string.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }
        try {
            int n = Integer.parseInt(string);
            System.out.println("Parsed input: " + n);
        }
        catch (NumberFormatException numberFormatException) {
            System.out.println("Invalid input format");
        }
    }

    private static String getInputFromUser() {
        return "123";
    }
}
