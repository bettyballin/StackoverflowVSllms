/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;

public class XSD2XML {
    public static void main(String[] stringArray) throws IOException {
        String string = "your_schema.xsd";
        String string2 = "your_schema.xml";
        ProcessBuilder processBuilder = new ProcessBuilder("xsd.exe", "/c", "/nologo", string);
        processBuilder.redirectOutput(new File(string2));
        processBuilder.start();
    }
}
