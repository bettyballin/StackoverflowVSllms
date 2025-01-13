public class Main_759 {
    public static void main(String[] args) {
        int[] array = {4, 5, 5, 5, 7, 8, 9, 10, 10};
        int[] missed = {3, 6, 11};
        int[] duplicates = {5, 10};

        System.out.println("Array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Missed: ");
        for (int i : missed) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Duplicates: ");
        for (int i : duplicates) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}