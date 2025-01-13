import java.lang.String;
public class Packet {
    public static final int HEADER_SIZE = 4;

    public byte actionId;
    public byte numParams;
    public short reserved;

    public Parameter[] params;

    public static class Parameter {
        public byte type;
        public short length;
        public byte[] data;
    }

	public static void main(String[] args) {
	}
}