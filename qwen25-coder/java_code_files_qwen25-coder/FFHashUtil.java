import java.lang.String;
public class FFHashUtil {

    public static void main(String[] args) {
        String a = "ABA/xxx.aba";
        String b = "CSS/xxx.css";
        String c = "JPG/xxx.jpg";

        System.out.println(getHash(a)); // should be 8ffac222
        System.out.println(getHash(b)); // should be 8ffac222
        System.out.println(getHash(c)); // should be 8ffac222

        String e = "modules_newsfeeds/MenuBar/MenuBar.css";
        String f = "modules_newsfeeds/ListBar/ListBar.css";

        System.out.println(getHash(e)); // should be 15c23729
        System.out.println(getHash(f)); // should be 15c23729

        String g = "modules_newsfeeds/MenuBar/MenuBar.js";
        String h = "modules_newsfeeds/ListBar/ListBar.js";

        System.out.println(getHash(g)); // should be a15c23e5
        System.out.println(getHash(h)); // should be a15c23e5
    }

    public static String getHash(String input) {
        int hash = 0;
        for (byte b : input.getBytes()) {
            hash = PR_ROTATE_LEFT32(hash, 8);
            hash ^= (b & 0xFF); // Important to mask off the sign bits of byte in Java
        }
        return String.format("%08x", hash);
    }

    public static int PR_ROTATE_LEFT32(int value, int shift) {
        return ((value << shift) | (value >>> (32 - shift)));
    }
}