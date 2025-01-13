/*
 * Decompiled with CFR 0.152.
 */
public class Main_334 {
    public static void main(String[] stringArray) {
        String string = "Hello everybody in stackoverflow";
        String[] stringArray2 = string.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = stringArray2.length - 1; i >= 0; --i) {
            stringBuilder.append(stringArray2[i]).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }
}
