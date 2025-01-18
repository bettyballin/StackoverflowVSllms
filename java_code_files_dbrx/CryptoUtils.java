import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Writer;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;

public class CryptoUtils {
    public static void main(String[] args) throws Exception {
        // Generate key (assuming that 'key' is a SecretKey)
        SecretKey key = KeyGenerator.getInstance("DESede").generateKey();

        // Get cipher instance
        Cipher cipher = Cipher.getInstance("DESede"); // or "Blowfish" or whatever you'd like

        // Encrypt
        BufferedReader br = new BufferedReader(new FileReader("normal.xml"));
        FileOutputStream fos_encrypted = new FileOutputStream("normal.xml.encrypted");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        CipherOutputStream cos = new CipherOutputStream(fos_encrypted, cipher);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(cos, StandardCharsets.UTF_8));
        String line;
        while ((line = br.readLine()) != null) { // Read file line by line and write to output stream.
            writer.write(line);
            writer.newLine(); // Write new line
        }
        writer.flush();
        writer.close(); // This will close cos and fos_encrypted
        br.close();

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, key);
        FileInputStream fis_encrypted = new FileInputStream("normal.xml.encrypted");
        CipherInputStream cis = new CipherInputStream(fis_encrypted, cipher);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(cis, StandardCharsets.UTF_8));
        FileWriter fw2_decrypted = new FileWriter("normal.xml.encrypted.xml"); // or whatever you'd like to write to
        BufferedWriter bw_decrypted = new BufferedWriter(fw2_decrypted);
        String line2;
        while ((line2 = br2.readLine()) != null ) { // Read decrypted file line by line and write to output stream.
            bw_decrypted.write(line2);
            bw_decrypted.newLine();
        }
        bw_decrypted.flush();
        bw_decrypted.close(); // Close the streams once done.
        br2.close();
    }
}