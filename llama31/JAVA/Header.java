import java.lang.String;
public class Header {
    public int version;
    public byte type;
    public int beginOfData;
    public byte[] id;

    public Header(int version, byte type, int beginOfData, byte[] id) {
        this.version = version;
        this.type = type;
        this.beginOfData = beginOfData;
        this.id = id;
    }

	public static void main(String[] args) {
	}
}