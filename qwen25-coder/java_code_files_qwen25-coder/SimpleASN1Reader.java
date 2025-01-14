import java.lang.String;
import java.lang.Integer;
import java.io.*;

public class SimpleASN1Reader {
    public static void main(String[] args) throws IOException {
        byte[] data = {0x30, 0x06, 0x02, 0x01, 0x04, 0x05, 0x01, 0x01}; // Simple sequence with two integers
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        DataInputStream dis = new DataInputStream(bais);
        
        int tag = dis.readUnsignedByte();
        int length = dis.readUnsignedByte();
        System.out.println("Tag: " + Integer.toHexString(tag) + ", Length: " + length);
        
        for (int i = 0; i < length; i++) {
            if (dis.available() > 1) { // Check to ensure there's at least two bytes left
                int subTag = dis.readUnsignedByte();
                int subLength = dis.readUnsignedByte();
                System.out.println("  Sub Tag: " + Integer.toHexString(subTag) + ", Length: " + subLength);
                byte[] valueBytes = new byte[subLength];
                dis.readFully(valueBytes);
                System.out.println("    Value: " + getIntegerFromBytes(valueBytes));
            }
        }
    }

    private static int getIntegerFromBytes(byte[] bytes) {
        int result = 0;
        for (byte b : bytes) {
            result = (result << 8) | (b & 0xFF);
        }
        return result;
    }
}