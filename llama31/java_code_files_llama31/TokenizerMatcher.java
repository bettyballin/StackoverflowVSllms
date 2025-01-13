/*
 * Decompiled with CFR 0.152.
 */
public class TokenizerMatcher {
    public boolean search(String string, String string2) {
        String[] stringArray = string.split("\\s+");
        String[] stringArray2 = string2.split("\\s+");
        for (String string3 : stringArray) {
            boolean bl = false;
            for (String string4 : stringArray2) {
                if (!string4.equals(string3)) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] stringArray) {
        TokenizerMatcher tokenizerMatcher = new TokenizerMatcher();
        System.out.println(tokenizerMatcher.search("hello world", "hello world"));
        System.out.println(tokenizerMatcher.search("hello world", "hello"));
    }
}
