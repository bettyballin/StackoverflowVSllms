/*
 * Decompiled with CFR 0.152.
 */
public class DateTimeAdder {
    public static String addTime(String string, String string2) {
        String[] stringArray = string.split(":");
        int n = Integer.parseInt(stringArray[0]);
        int n2 = Integer.parseInt(stringArray[1]);
        int n3 = stringArray.length > 2 ? Integer.parseInt(stringArray[2]) : 0;
        String[] stringArray2 = string2.split(":");
        int n4 = Integer.parseInt(stringArray2[0]);
        int n5 = Integer.parseInt(stringArray2[1]);
        int n6 = Integer.parseInt(stringArray2[2]);
        n += n4 + (n2 += n5 + (n3 += n6) / 60) / 60;
        return String.format("%02d:%02d:%02d", n %= 24, n2 %= 60, n3 %= 60);
    }

    public static void main(String[] stringArray) {
        System.out.println(DateTimeAdder.addTime("13:30", "02:02:02"));
        System.out.println(DateTimeAdder.addTime("13:30", "00:00:01"));
        System.out.println(DateTimeAdder.addTime("13:30", "00:01:00"));
    }
}
