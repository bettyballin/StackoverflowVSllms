/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class StringChunker {
    private List<String> breakStringInChunks(String string, int n) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = 0;
        while (n2 < string.length()) {
            int n3 = Math.min(n2 + n, string.length());
            arrayList.add(string.substring(n2, n3));
            n2 = n3;
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        StringChunker stringChunker = new StringChunker();
        String string = "Hello, World!";
        int n = 5;
        List<String> list = stringChunker.breakStringInChunks(string, n);
        System.out.println(list);
    }
}
