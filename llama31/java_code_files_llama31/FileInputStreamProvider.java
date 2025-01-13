/*
 * Decompiled with CFR 0.152.
 */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileInputStreamProvider {
    private String inputPath;

    public FileInputStreamProvider(String string) {
        this.inputPath = string;
    }

    public InputStream getInputStream() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream fileInputStream = new FileInputStream(this.inputPath);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));){
            String string;
            boolean bl = true;
            while ((string = bufferedReader.readLine()) != null) {
                if (!bl) {
                    byteArrayOutputStream.write("\r\n".getBytes());
                }
                byteArrayOutputStream.write(string.getBytes());
                bl = false;
            }
        }
        catch (Throwable throwable) {
            System.err.println("Error: " + throwable.getMessage());
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public static void main(String[] stringArray) {
        FileInputStreamProvider fileInputStreamProvider = new FileInputStreamProvider("path_to_your_file.txt");
        try {
            InputStream inputStream = fileInputStreamProvider.getInputStream();
        }
        catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }
    }
}
