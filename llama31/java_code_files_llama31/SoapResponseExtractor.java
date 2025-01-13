/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class SoapResponseExtractor {
    public static void main(String[] stringArray) throws IOException {
        String string = "...";
        String string2 = string.split("<return>")[1].split("</return>")[0];
        byte[] byArray = Base64.getDecoder().decode(string2);
        File file = new File("output.zip");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(byArray);
        fileOutputStream.close();
        System.out.println("Zip file saved to: " + file.getAbsolutePath());
    }
}
