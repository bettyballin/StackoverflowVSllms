import java.lang.String;
import java.lang.Integer;
public class File {
    private int size;

    // Getter for size
    public int getSize() {
        return size;
    }

    // Setter for size
    public void setSize(int size) {
        this.size = size;
    }

    // Custom logic getter/setter example
    public String getSizeHex() {
        return String.format("%0X", size);
    }

    public void setSizeHex(String hexSize) {
        this.size = Integer.parseInt(hexSize, 16);
    }

	public static void main(String[] args) {
	}
}