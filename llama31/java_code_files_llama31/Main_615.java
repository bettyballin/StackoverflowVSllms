/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Main_615 {
    public static void main(String[] stringArray) {
        Object[] objectArray = new String[]{"apple", "banana", "cherry", "date"};
        String string = "banana";
        objectArray = Main_615.removeElement((String[])objectArray, string);
        System.out.println(Arrays.toString(objectArray));
    }

    public static String[] removeElement(String[] stringArray, String string) {
        return (String[])Arrays.stream(stringArray).filter(string2 -> !string2.equals(string)).toArray(String[]::new);
    }
}
