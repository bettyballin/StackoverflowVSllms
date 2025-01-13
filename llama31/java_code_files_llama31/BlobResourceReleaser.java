/*
 * Decompiled with CFR 0.152.
 */
import java.io.InputStream;
import java.sql.Blob;

public class BlobResourceReleaser {
    public static void main(String[] stringArray) throws Exception {
        InputStream inputStream = null;
        Blob blob = null;
        if (inputStream != null) {
            inputStream.close();
        }
        if (blob != null) {
            blob.free();
        }
    }
}
