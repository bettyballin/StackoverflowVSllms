import java.lang.String;
import java.util.Arrays;

public class ArrayCollection {

    private Object[] elementData = new Object[0];
    private int size = 0;

    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());

        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    public static void main(String[] args) {
    }
}