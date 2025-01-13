import java.lang.String;
public class PaddedStringBuilder {
    private StringBuilder sb;

    public PaddedStringBuilder() {
        sb = new StringBuilder();
    }

    public PaddedStringBuilder append(String str) {
        sb.append(str).append(" ");
        return this;
    }

    public String toString() {
        return sb.toString().trim(); // remove trailing space
    }

	public static void main(String[] args) {
	}
}