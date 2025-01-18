import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class Encryptor {
    private static byte[] encryptFile(String filePath, String key) throws Exception {
        // Reading the original file into memory in bytes.
        File f = new File(filePath);
        int length = (int) f.length();
        byte[] inputData = new byte[length];
        try {
            BufferedInputStream buffInputStrm = new BufferedInputStream(new FileInputStream(f));
            DataInputStream dataInputStrm = new DataInputStream(buffInputStrm);
            dataInputStrm.readFully(inputData, 0, inputData.length);
            dataInputStrm.close();
        } catch (IOException ex) {
            throw ex;
        }
        // Determining if a pad is needed and adding appropriate bytes at the end of the data block
        int blocks = length % 8 > 0 ? length / 8 + 1 : length / 8;
        byte[] padding = new byte[blocks * 8 - length];
        Arrays.fill(padding, (byte) 0x0);
        // Concatenate inputData and padding
        byte[] paddedInputData = new byte[inputData.length + padding.length];
        System.arraycopy(inputData, 0, paddedInputData, 0, inputData.length);
        System.arraycopy(padding, 0, paddedInputData, inputData.length, padding.length);
        inputData = paddedInputData;
        // Creating a Cipher and initializing it for encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        SecretKeySpec keyObj = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keyObj);
        byte[] encryptedData = new byte[cipher.getOutputSize(inputData.length)];
        int eLength = cipher.update(inputData, 0, inputData.length, encryptedData, 0);
        if (eLength < encryptedData.length) {
            int len = cipher.doFinal(encryptedData, eLength);
            eLength += len;
        }
        return encryptedData;
    }
}