/*
 * Decompiled with CFR 0.152.
 */
public class NoDuplicateListMain {
    public static void main(String[] stringArray) {
        NoDuplicateList<String> noDuplicateList = new NoDuplicateList<String>();
        noDuplicateList.add("apple");
        noDuplicateList.add("banana");
        noDuplicateList.add("apple");
        System.out.println(noDuplicateList);
    }
}
