import java.lang.String;
public class HashCalculator {
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public static void main(String[] args) {
    }
}