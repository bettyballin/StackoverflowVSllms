public class NullArrayFiller {
    public void clearArray(String[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                array[i] = null;
            }
        }
    }
    public static void main(String[] args) {
    }
}