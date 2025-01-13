/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;

public class Main_540 {
    public static void main(String[] stringArray) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("hello", "world");
        String string = (String)hashMap.get("hello");
        System.out.println(string);
        Trie trie = new Trie();
        trie.insert("hello", "world");
        String string2 = trie.get("hello");
        System.out.println(string2);
    }
}
