/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CSVWriter {
    public static void main(String[] stringArray) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("fileName.csv");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 32768);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);
    }
}
