/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

public class Main_694 {
    public static void main(String[] stringArray) {
        CategoryCountManager categoryCountManager = new CategoryCountManager();
        Hashtable<String, Hashtable<String, Integer>> hashtable = categoryCountManager.getFunctionWithSubFunctionCount(1L);
        Set<String> set = hashtable.keySet();
        for (String string : set) {
            System.out.println("***************************");
            System.out.println(string);
            System.out.println("***************************");
            Hashtable<String, Integer> hashtable2 = hashtable.get(string);
            Vector<String> vector = new Vector<String>(hashtable2.keySet());
            Collections.sort(vector);
            for (String string2 : vector) {
                System.out.println("#" + string2 + "-" + String.valueOf(hashtable2.get(string2)));
            }
        }
    }
}
