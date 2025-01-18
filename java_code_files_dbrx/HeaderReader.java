import java.io.*;

public class HeaderReader {
    private static Header readHeader(DataInput in) throws IOException {
        Header hdr = new Header();

        // read fields following java's primitive datatype getters e.g.
        /* Version is 4 bytes (an int is also 4 bytes so you can use `readInt`) */
        hdr.version = in.readInt();

        /* Type, being a byte, would be one byte so we can use `readByte`. But be careful when reading chars/strings since they take multiple bytes depending on encoding */
        hdr.type = in.readByte();

        // and so on...
        return hdr;
    }

    public static void main(String[] args) {
    }

    // Inner class Header
    static class Header {
        int version;
        byte type;
        // other fields if necessary
    }
}