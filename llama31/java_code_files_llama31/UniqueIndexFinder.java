/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;

public class UniqueIndexFinder {
    public int firstUniqueIndex(String[] stringArray) {
        int n = Integer.MAX_VALUE;
        for (String string : stringArray) {
            n = Math.min(n, string.length());
        }
        for (int i = 0; i < n; ++i) {
            HashSet<Character> hashSet = new HashSet<Character>();
            for (String string : stringArray) {
                if (!hashSet.add(Character.valueOf(string.charAt(i)))) break;
            }
            if (hashSet.size() != stringArray.length) continue;
            return i;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        UniqueIndexFinder uniqueIndexFinder = new UniqueIndexFinder();
        String[] stringArray2 = new String[]{"hello", "world", "hellu"};
        System.out.println(uniqueIndexFinder.firstUniqueIndex(stringArray2));
    }
}
