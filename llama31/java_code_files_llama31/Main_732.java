/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Main_732 {
    public static void main(String[] stringArray) throws IOException {
        String string = "{\"key\":\"value\"}";
        byte[] byArray = string.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(byArray);
        gZIPOutputStream.close();
        byte[] byArray2 = byteArrayOutputStream.toByteArray();
        System.out.println(byArray2.length + " bytes compressed");
    }
}
