import java.lang.String;

public class PKCS7PaddingUtil {
    public static byte[] pkcs7Pad(byte[] data, int blockSize) {
        int paddingLength = blockSize - (data.length % blockSize);
        byte[] paddedData = new byte[data.length + paddingLength];
        System.arraycopy(data, 0, paddedData, 0, data.length);
        for (int i = data.length; i < paddedData.length; i++) {
            paddedData[i] = (byte) paddingLength;
        }
        return paddedData;
    }

    public static byte[] pkcs7Unpad(byte[] paddedData, int blockSize) {
        int paddingLength = paddedData[paddedData.length - 1];
        if (paddingLength > blockSize || paddingLength < 1) {
            throw new RuntimeException("Invalid padding");
        }
        for (int i = paddedData.length - 1; i >= paddedData.length - paddingLength; i--) {
            if (paddedData[i] != (byte) paddingLength) {
                throw new RuntimeException("Invalid padding");
            }
        }
        byte[] data = new byte[paddedData.length - paddingLength];
        System.arraycopy(paddedData, 0, data, 0, data.length);
        return data;
    }

    public static void main(String[] args) {
    }
}