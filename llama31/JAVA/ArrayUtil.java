import java.lang.String;

public class ArrayUtil {
    public static String[] removeElement(String[] array, String elementToRemove) {
        int newSize = 0;
        for (String element : array) {
            if (!element.equals(elementToRemove)) {
                newSize++;
            }
        }

        String[] newArray = new String[newSize];
        int j = 0;
        for (String element : array) {
            if (!element.equals(elementToRemove)) {
                newArray[j] = element;
                j++;
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
    }
}