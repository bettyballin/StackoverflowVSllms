import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FileUtils;

public class Test_1_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File tempFile = null;
        try {
            tempFile = File.createTempFile("temp", "txt");
            try {
                FileOutputStream fos = new FileOutputStream(tempFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                // Do something with oos

                oos.close();
                fos.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (tempFile != null)
                FileUtils.deleteQuietly(tempFile);
        }

    }

}