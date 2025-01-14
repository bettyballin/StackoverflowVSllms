import java.lang.String;

public class ArrayCopier {
    int[] src = {1, 2, 3, 4, 5};
    int[] dest = new int[10];

    {
        // Copy elements from index 2 of src to index 0 of dest, copy 3 elements
        System.arraycopy(src, 2, dest, 0, 3);
    }

    public static void main(String[] args) {
    }
}