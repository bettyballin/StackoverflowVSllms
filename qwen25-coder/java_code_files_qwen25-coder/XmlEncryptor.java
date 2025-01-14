import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class XmlEncryptor {
    private static SecretKey secretKey;

    public static byte[] encrypt(String valueToEnc) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(valueToEnc.getBytes());
    }

    public static String decrypt(byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedValue = cipher.doFinal(encryptedData);
        return new String(decryptedValue);
    }

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example
        secretKey = keyGen.generateKey();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xsw = xmlOutputFactory.createXMLStreamWriter(baos, "UTF-8");

        xsw.writeStartElement("encryptedData");
        StringBuilder sb = new StringBuilder();
        
        // Simulate large XML content accumulation
        for(int i = 0; i < 1000000; i++) {
            sb.append("<row>").append(i).append("</row>");
        }

        byte[] encryptedData = encrypt(sb.toString());
        String encodedEncryptedData = Base64.getEncoder().encodeToString(encryptedData);
        
        xsw.writeCharacters(encodedEncryptedData);
        xsw.writeEndElement();
        xsw.close();

        System.out.println("Base64 Encoded XML Content: " + baos.toString());

        // To decrypt:
        String xmlContent = baos.toString(); // You'd normally read this from your XML source
        int indexStart = xmlContent.indexOf("<encryptedData>") + "<encryptedData>".length();
        int indexEnd = xmlContent.lastIndexOf("</encryptedData>");
        String base64EncodedEncryptedData = xmlContent.substring(indexStart, indexEnd);
        
        byte[] decodedEncryptedData = Base64.getDecoder().decode(base64EncodedEncryptedData);
        String decryptedData = decrypt(decodedEncryptedData);
        
        System.out.println("Decrypted Data: " + decryptedData);
    }
}