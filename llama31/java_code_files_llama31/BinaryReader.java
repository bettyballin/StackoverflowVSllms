/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryReader {
    public static void main(String[] stringArray) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("example.bin"));){
            int n = dataInputStream.readInt();
            byte by = dataInputStream.readByte();
            int n2 = dataInputStream.readInt();
            byte[] byArray = new byte[16];
            dataInputStream.readFully(byArray);
            while (dataInputStream.available() > 0) {
                int n3 = dataInputStream.readInt();
                byte[] byArray2 = new byte[n3];
                dataInputStream.readFully(byArray2);
            }
        }
    }
}
