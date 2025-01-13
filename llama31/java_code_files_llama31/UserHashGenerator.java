/*
 * Decompiled with CFR 0.152.
 */
public class UserHashGenerator {
    public int getTableSuffix(String string, int n) {
        int n2 = 0;
        for (char c : string.toCharArray()) {
            n2 += c;
        }
        return n2 % n + 1;
    }

    public static void main(String[] stringArray) {
        UserHashGenerator userHashGenerator = new UserHashGenerator();
        String string = "exampleUser";
        int n = 10;
        int n2 = userHashGenerator.getTableSuffix(string, n);
        System.out.println("Table suffix for " + string + ": " + n2);
    }
}
