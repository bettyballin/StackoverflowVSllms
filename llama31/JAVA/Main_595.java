import java.util.Arrays;

public class Main_595 {
    public static void main(String[] args) {
        String[] a = {"apple", "banana", "cherry"};
        String[] b = {"banana", "date", "elderberry"};

        boolean intersect = Main.intersect(a, b, String::compareTo);
        System.out.println(intersect); // true
    }

    public static <T> boolean intersect(T[] a, T[] b, java.util.Comparator<? super T> cmp) {
        Arrays.sort(a, cmp);
        Arrays.sort(b, cmp);

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int c = cmp.compare(a[i], b[j]);
            if (c < 0) {
                i++;
            } else if (c > 0) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}