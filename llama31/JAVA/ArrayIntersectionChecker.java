import java.lang.String;

public class ArrayIntersectionChecker {
    public static boolean intersect(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                return true; // found an intersection
            }
        }
        return false; // no intersection found
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 6, 7, 8};
        System.out.println("Do arrays intersect? " + intersect(a, b));
    }
}