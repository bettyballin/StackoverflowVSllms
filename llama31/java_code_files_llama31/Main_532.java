/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;
import java.net.URISyntaxException;

public class Main_532 {
    public static void main(String[] stringArray) throws URISyntaxException {
        String string = "/var/data/stuff/xyz.dat";
        String string2 = "/var/data";
        URI uRI = new URI("file", "", string, "", "");
        URI uRI2 = new URI("file", "", string2, "", "");
        URI uRI3 = uRI2.relativize(uRI);
        System.out.println(uRI3.getPath());
    }
}
