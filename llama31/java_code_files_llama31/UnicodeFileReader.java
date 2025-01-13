/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class UnicodeFileReader {
    public static void main(String[] stringArray) throws IOException {
        String string = "path/to/your/file.txt";
        Charset charset = Charset.forName("UTF-16");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(string), charset));){
            String string2;
            while ((string2 = bufferedReader.readLine()) != null) {
                System.out.println(string2);
            }
        }
    }
}
