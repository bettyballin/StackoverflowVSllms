import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main_801_801 {
    public static void main(String[] args) throws Exception {
        // Initialize keys
        byte[] key1 = new byte[8];
        byte[] key2 = new byte[48];

        for (int i = 0; i < 8; i++) {
            key1[i] = (byte) (31 + (i * Math.sqrt(i * 5)) % 100);
        }

        for (int i = 0; i < 48; i++) {
            key2[i] = (byte) (31 + (i * i * Math.sqrt(i * 2)) % 100);
        }

        // Initialize input data
        String input = "Hello, World!";
        byte[] bufferToEncrypt = input.getBytes("UTF-8");

        // Add begin text and end text to the encrypted message
        byte[] beginText = new byte[]{2};
        byte[] endText = new byte[]{3};
        byte[] inputData = new byte[beginText.length + bufferToEncrypt.length + endText.length];
        System.arraycopy(beginText, 0, inputData, 0, beginText.length);
        System.arraycopy(bufferToEncrypt, 0, inputData, beginText.length, bufferToEncrypt.length);
        System.arraycopy(endText, 0, inputData, beginText.length + bufferToEncrypt.length, endText.length);

        // Add padding
        byte[] paddedData = pad(inputData);

        // Encrypt data
        Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(key1, "DES");
        IvParameterSpec ivSpec = new IvParameterSpec(key2, 0, 8);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encryptedData = cipher.doFinal(paddedData);

        // Encode encrypted data in Base64
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        String encryptedString = encoder.encodeToString(encryptedData);
        System.out.println(encryptedString);
    }

    private static byte[] pad(byte[] data) {
        int paddingSize = 8 - (data.length % 8);
        byte[] paddedData = new byte[data.length + paddingSize];
        System.arraycopy(data, 0, paddedData, 0, data.length);
        for (int i = data.length; i < paddedData.length; i++) {
            paddedData[i] = (byte) paddingSize;
        }
        return paddedData;
    }
}