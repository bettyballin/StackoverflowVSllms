/*
 * Decompiled with CFR 0.152.
 */
import java.net.URI;

public class Main_417 {
    public static void main(String[] stringArray) {
        URI uRI = URI.create("http://someDomain/someFile.dat");
        System.out.println(uRI);
        uRI = URI.create("file://c:/files/someFile.dat");
        System.out.println(uRI);
        uRI = URI.create("c:/files/someFile.dat");
        System.out.println(uRI);
    }
}
