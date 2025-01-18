public class JaggedArrayIterator {
    // Here is how to iterate a jagged array in Java:
    public static void main(String[] args) {
        String[][] arr = {{"a", "b"}, {"c", "d", "e"}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}