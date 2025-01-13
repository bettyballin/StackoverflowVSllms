/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.Key;

public class DecryptingClassLoader
extends URLClassLoader {
    private Key decryptionKey;

    public DecryptingClassLoader(URL[] uRLArray, Key key) {
        super(uRLArray);
        this.decryptionKey = key;
    }

    @Override
    protected Class<?> findClass(String string) throws ClassNotFoundException {
        byte[] byArray = this.loadResource(string.replace('.', '/') + ".class");
        byte[] byArray2 = this.decrypt(byArray);
        return this.defineClass(string, byArray2, 0, byArray2.length);
    }

    private byte[] loadResource(String string) {
        try {
            URL uRL = this.getResource(string);
            InputStream inputStream = uRL.openStream();
            byte[] byArray = new byte[inputStream.available()];
            inputStream.read(byArray);
            inputStream.close();
            return byArray;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private byte[] decrypt(byte[] byArray) {
        return byArray;
    }

    public static void main(String[] stringArray) {
    }
}
