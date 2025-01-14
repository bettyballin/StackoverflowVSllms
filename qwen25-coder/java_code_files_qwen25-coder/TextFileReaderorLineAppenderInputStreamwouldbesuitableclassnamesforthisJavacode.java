import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.File;

public class TextFileReaderorLineAppenderInputStreamwouldbesuitableclassnamesforthisJavacode {
    public InputStream getInputStream(String inputPath) throws Exception {
        File file = new File(inputPath);
        StringBuilder holder = new StringBuilder((int) (file.length() * 1.5));
        try (FileInputStream reader = new FileInputStream(inputPath);
             BufferedReader br = new BufferedReader(new InputStreamReader(reader))) {

            String strLine;
            boolean notFirstLine = false;
            while ((strLine = br.readLine()) != null) {
                if (notFirstLine)
                    holder.append('\r').append('\n');

                holder.append(strLine);
                notFirstLine = true;
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }

        return new ByteArrayInputStream(holder.toString().getBytes());
    }

    public static void main(String[] args) {
    }
}