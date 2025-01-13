/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;

class CategoryCountManager {
    CategoryCountManager() {
    }

    public Hashtable<String, Hashtable<String, Integer>> getFunctionWithSubFunctionCount(long l) {
        Hashtable<String, Hashtable<String, Integer>> hashtable = new Hashtable<String, Hashtable<String, Integer>>();
        Hashtable<String, Integer> hashtable2 = new Hashtable<String, Integer>();
        hashtable2.put("subFunction1", 1);
        hashtable2.put("subFunction2", 2);
        hashtable.put("function1", hashtable2);
        return hashtable;
    }
}
