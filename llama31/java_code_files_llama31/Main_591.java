/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;

public class Main_591 {
    public static void main(String[] stringArray) {
        HelperClass helperClass = new HelperClass();
        byte[] byArray = new byte[]{1, 2, 3};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        helperClass.addInline("cImage", byteArrayInputStream);
    }
}
