/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class FileEncoder {
    public static void main(String[] stringArray) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream("file.txt"), "UTF-8"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter((OutputStream)new FileOutputStream("file.txt"), "UTF-8"));
    }
}
