/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class CustomHashMap {
    private HashMap<Integer, Object> map = new HashMap();

    public void myPut(int n) {
        this.map.put(n, null);
    }

    public static void main(String[] stringArray) {
        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.myPut(1);
    }
}
