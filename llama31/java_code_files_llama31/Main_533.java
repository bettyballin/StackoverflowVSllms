/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;

public class Main_533 {
    public static void main(String[] stringArray) throws URISyntaxException {
        String string = "stuff/xyz.dat";
        URI uRI = new URI(null, null, string, null);
        String string2 = "./" + uRI.getPath();
        System.out.println(string2);
    }
}
