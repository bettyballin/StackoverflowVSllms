import java.util.Arrays;

public class Main_615 {
    public static void main(String[] args) {
        String[] array = {"apple", "banana", "cherry", "date"};
        String elementToRemove = "banana";

        array = removeElement(array, elementToRemove);

        System.out.println(Arrays.toString(array));
    }

    public static String[] removeElement(String[] array, String elementToRemove) {
        return Arrays.stream(array)
                .filter(element -> !element.equals(elementToRemove))
                .toArray(String[]::new);
    }
}