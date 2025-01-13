import java.lang.String;
import java.lang.Integer;
public class FirefoxCacheHash {
    public static void main(String[] args) {
        System.out.println(getHash("ABA/xxx.aba")); // 8ffac222
        System.out.println(getHash("CSS/xxx.css")); // 8ffac222
        System.out.println(getHash("JPG/xxx.jpg")); // 8ffac222
        System.out.println(getHash("modules_newsfeeds/MenuBar/MenuBar.css")); // 15c23729
        System.out.println(getHash("modules_newsfeeds/ListBar/ListBar.css")); // 15c23729
        System.out.println(getHash("modules_newsfeeds/MenuBar/MenuBar.js")); // a15c23e5
        System.out.println(getHash("modules_newsfeeds/ListBar/ListBar.js")); // a15c23e5
    }

    public static String getHash(String url) {
        char[] cs = url.toCharArray();
        int h = 0;
        for (char c : cs) {
            h = rotateLeft(h, 4) ^ c;
        }
        return Integer.toHexString(h);
    }

    public static int rotateLeft(int a, int bits) {
        return (a << bits) | (a >>> (32 - bits));
    }
}