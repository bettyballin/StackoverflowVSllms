import java.lang.String;

public class EfficientDataProcessor {

    public void processData(int[] data) {
        // Avoid creating unnecessary objects
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(data[i]);
        }
        String result = stringBuilder.toString(); // Create once
    }
    
    // Efficient Array Usage
    public int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length]; // Allocate array once outside the loop
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);
        return mergedArray;
    }

    public static void main(String[] args) {
    }
}