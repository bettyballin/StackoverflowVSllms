import java.lang.String;
import java.lang.Integer;
import java.util.Comparator;

public class ArrayIntersectionChecker {
    public static <T> boolean doArraysIntersect(T[] arrayA, T[] arrayB, Comparator<T> comparator) {
        int i = 0;
        int j = 0;

        while (i < arrayA.length && j < arrayB.length) {
            int comparisonResult = comparator.compare(arrayA[i], arrayB[j]);

            if (comparisonResult == 0) {
                return true; // Found an intersection
            } else if (comparisonResult < 0) {
                i++; // Move pointer in arrayA forward
            } else {
                j++; // Move pointer in arrayB forward
            }
        }

        return false; // No intersection found
    }

    public static void main(String[] args) {
        Integer[] arrayA = {5, 17, 150, 230, 285};
        Integer[] arrayB = {7, 11, 57, 110, 230, 250};

        boolean intersectionExists = doArraysIntersect(arrayA, arrayB, Comparator.naturalOrder());
        System.out.println("Do arrays intersect? " + intersectionExists);
    }
}