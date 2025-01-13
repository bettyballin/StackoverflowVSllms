/*
 * Decompiled with CFR 0.152.
 */
public class Main_414 {
    public static String getQuarter(int n) {
        return switch (n) {
            case 1 -> "Winter";
            case 2 -> "Spring";
            case 3 -> "Summer I";
            case 4 -> "Summer II";
            case 5 -> "Fall";
            default -> "ERROR";
        };
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_414.getQuarter(1));
    }
}
