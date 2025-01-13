import java.lang.String;
public class MemMoveExample {
    public static void main(String[] args) {
        byte[] src = {1, 2, 3, 4, 5};
        byte[] dst = new byte[5];

        // equivalent to memmove(dst, src, 5)
        System.arraycopy(src, 0, dst, 0, 5);

        // print the result
        for (byte b : dst) {
            System.out.print(b + " ");
        }
    }
}