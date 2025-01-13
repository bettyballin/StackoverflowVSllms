import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import com.thoughtworks.xstream.XStream;

public class ExchangeFormat {
    private static final byte[] DELIMITER = new byte[] { '\0' };
    private static final String HASH_ALGORITHM = "MD5";

    public static void write(OutputStream out, Object obj, String[] fileNames, byte[][] fileData) throws IOException, NoSuchAlgorithmException {
        // Serialize object to XML
        XStream xs = new XStream();
        String xml = xs.toXML(obj);

        // Write XML object
        out.write(xml.getBytes(StandardCharsets.UTF_8));
        out.write(DELIMITER);

        // Write file sections
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        for (int i = 0; i < fileNames.length; i++) {
            out.write(fileNames[i].getBytes(StandardCharsets.UTF_8));
            out.write(DELIMITER);
            out.write(fileData[i]);
            out.write(DELIMITER);

            // Update MD5 hash
            md.update(fileNames[i].getBytes(StandardCharsets.UTF_8));
            md.update(fileData[i]);
        }

        // Write final delimiter and MD5 hash
        out.write(DELIMITER);
        byte[] hash = md.digest();
        out.write(hash);
    }

    public static void read(InputStream in) throws IOException, NoSuchAlgorithmException {
        // Read XML object
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            if (bytesRead == DELIMITER.length && buffer[0] == DELIMITER[0]) {
                break;
            }
            baos.write(buffer, 0, bytesRead);
        }
        String xml = new String(baos.toByteArray(), StandardCharsets.UTF_8);
        Object obj = new XStream().fromXML(xml);

        // Read file sections
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        while (true) {
            // Read file name
            baos.reset();
            while ((bytesRead = in.read(buffer)) != -1) {
                if (bytesRead == DELIMITER.length && buffer[0] == DELIMITER[0]) {
                    break;
                }
                baos.write(buffer, 0, bytesRead);
            }
            String fileName = new String(baos.toByteArray(), StandardCharsets.UTF_8);

            // Read file data
            baos.reset();
            while ((bytesRead = in.read(buffer)) != -1) {
                if (bytesRead == DELIMITER.length && buffer[0] == DELIMITER[0]) {
                    break;
                }
                baos.write(buffer, 0, bytesRead);
            }
            byte[] fileData = baos.toByteArray();

            // Update MD5 hash
            md.update(fileName.getBytes(StandardCharsets.UTF_8));
            md.update(fileData);

            // Check for final delimiter
            if (in.read(buffer) == -1 || buffer[0] != DELIMITER[0]) {
                break;
            }
        }

        // Check MD5 hash
        byte[] hash = md.digest();
        byte[] expectedHash = new byte[hash.length];
        in.read(expectedHash);
        if (!Arrays.equals(hash, expectedHash)) {
            throw new IOException("Invalid MD5 hash");
        }
    }

    public static void main(String[] args) throws Exception {
        // Create test data
        Object obj = "Hello, World!";
        String[] fileNames = {"file1.txt", "file2.txt"};
        byte[][] fileData = { "File 1 content".getBytes(), "File 2 content".getBytes() };

        // Write to file
        FileOutputStream out = new FileOutputStream("output.bin");
        write(out, obj, fileNames, fileData);
        out.close();

        // Read from file
        FileInputStream in = new FileInputStream("output.bin");
        read(in);
        in.close();
    }
}