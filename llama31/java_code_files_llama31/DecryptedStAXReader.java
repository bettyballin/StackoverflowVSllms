/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  DecryptedInputStream
 */
import java.io.FileInputStream;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class DecryptedStAXReader {
    public static void main(String[] stringArray) throws Exception {
        String string = "your_secret_key_here";
        SecretKeySpec secretKeySpec = new SecretKeySpec(string.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, secretKeySpec);
        XMLInputFactory xMLInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xMLStreamReader = xMLInputFactory.createXMLStreamReader((InputStream)new DecryptedInputStream((InputStream)new FileInputStream("encrypted.xml"), cipher));
        while (xMLStreamReader.hasNext()) {
            xMLStreamReader.next();
        }
        xMLStreamReader.close();
    }
}
