/*
 * Decompiled with CFR 0.152.
 */
public class FirefoxCacheHash {
    public static void main(String[] stringArray) {
        System.out.println(FirefoxCacheHash.getHash("ABA/xxx.aba"));
        System.out.println(FirefoxCacheHash.getHash("CSS/xxx.css"));
        System.out.println(FirefoxCacheHash.getHash("JPG/xxx.jpg"));
        System.out.println(FirefoxCacheHash.getHash("modules_newsfeeds/MenuBar/MenuBar.css"));
        System.out.println(FirefoxCacheHash.getHash("modules_newsfeeds/ListBar/ListBar.css"));
        System.out.println(FirefoxCacheHash.getHash("modules_newsfeeds/MenuBar/MenuBar.js"));
        System.out.println(FirefoxCacheHash.getHash("modules_newsfeeds/ListBar/ListBar.js"));
    }

    public static String getHash(String string) {
        char[] cArray = string.toCharArray();
        int n = 0;
        for (char c : cArray) {
            n = FirefoxCacheHash.rotateLeft(n, 4) ^ c;
        }
        return Integer.toHexString(n);
    }

    public static int rotateLeft(int n, int n2) {
        return n << n2 | n >>> 32 - n2;
    }
}
