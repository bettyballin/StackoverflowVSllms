import java.io.*;

class Header {
    int version;
    byte type;
    int beginOfData;
    char[] id = new char[16]; // assuming it's 16 chars long, as in your example
}

public class ReadBinaryFile {

    public static Header readHeader(DataInputStream dis) throws IOException {
        Header header = new Header();
        header.version = dis.readInt();
        header.type = dis.readByte();
        header.beginOfData = dis.readInt();
        for (int i = 0; i < header.id.length; i++) {
            header.id[i] = dis.readChar();
        }
        return header;
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("your_file.bin");
        DataInputStream dis = new DataInputStream(fis);
        Header header = readHeader(dis); // assuming we have this method
    }
}