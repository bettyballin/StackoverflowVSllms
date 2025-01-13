/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;

public class SetUtilorSetExample {
    public static void main(String[] stringArray) {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Hello");
        hashSet.add("World");
        String string = (String)hashSet.iterator().next();
        System.out.println(string);
    }
}
