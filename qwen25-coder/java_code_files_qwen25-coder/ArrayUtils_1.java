public class ArrayUtils_1 {
    /**
     * Returns true if the array contains a specific element.
     *
     * @param array Array to search within. Should be non-null.
     * @param elem Element to find in the array.
     * @return True if the element is present, false otherwise.
     */
    public boolean contains(int[] array, int elem) {
        // Precondition assertion
        assert array != null;

        for (int e : array) {
            if (e == elem)
                return true;
        }
        return false;        
        // Postcondition implicitly checked by method correctness
    }

    public static void main(String[] args) {
    }
}