/*
 * Decompiled with CFR 0.152.
 */
public class Permutations {
    public static void permute(String string) {
        if (string.length() == 1) {
            System.out.println(string);
        } else {
            for (int i = 0; i < string.length(); ++i) {
                String string2 = string.substring(0, i) + string.substring(i + 1);
                Permutations.permute(string2 + string.charAt(i));
            }
        }
    }

    public static void main(String[] stringArray) {
        String string = "abc";
        System.out.println("Permutations of " + string + ":");
        Permutations.permute(string);
    }
}
