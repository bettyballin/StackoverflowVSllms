import java.lang.String;
import java.lang.Integer;
public class MyKey {
    private final int id;

    public MyKey(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        // Simple hash function tailored to your application needs
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyKey)) return false;
        MyKey that = (MyKey) obj;
        return id == that.id;
    }

	public static void main(String[] args) {
	}
}