/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;

public class MyJavaClass_1 {
    private static Hashtable<String, String> myTable = new Hashtable();

    public static void main(String[] stringArray) {
        myTable.put("key1", "value1");
        System.out.println(myTable.get("key1"));
    }
}
