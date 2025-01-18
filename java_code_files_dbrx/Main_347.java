import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Example array
        int[] array = {5, 2, 8, 1, 3};
        Arrays.sort(array); // This uses TimSort internally in Java

        // Example list
        List<Integer> list = Arrays.asList(5, 2, 8, 1, 3);
        Collections.sort(list); // This also uses TimSort when sorting List objects in Java
    }
}