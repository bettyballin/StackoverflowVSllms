import java.io.*;

public class TempFileCreator_1 {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            InputStream stream = new FileInputStream(new File("YourJarPath", "myTemplate.dot"));
            in = stream;  // Assign to 'in' so we can close it in finally
            byte[] buffer = new byte[stream.available()]; // Read your file to a Byte Array (buffer)
            stream.read(buffer);

            File tempFile;
            try {
                tempFile = File.createTempFile("tempfile", ".dot");  // Create a temporary file that we can write the buffer to
                OutputStream out = new FileOutputStream(tempFile);
                out.write(buffer);  // Write all bytes from buffer to the new empty file (overwriting it if needed).
                out.close();  // Close the output stream
            } catch (IOException e) {
                throw new RuntimeException("Failed to create temp file for word template", e);
            }
            String absolutePath = tempFile.getAbsolutePath();  // Get Absolute Path of your file
            System.out.println("Temp file created at: " + absolutePath);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {  // Always close streams when done!
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}