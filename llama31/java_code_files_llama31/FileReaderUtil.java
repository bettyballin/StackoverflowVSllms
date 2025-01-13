/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReaderUtil {
    private static String readFileAsString(String string) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(1000);
        FileInputStream fileInputStream = new FileInputStream(string);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        char[] cArray = new char[1024];
        int n = 0;
        while ((n = bufferedReader.read(cArray)) != -1) {
            String string2 = String.valueOf(cArray, 0, n);
            stringBuffer.append(string2);
            cArray = new char[1024];
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }

    public static void main(String[] stringArray) {
    }
}
