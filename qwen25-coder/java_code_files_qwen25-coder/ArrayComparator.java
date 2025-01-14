import java.lang.String;
public class ArrayComparator {
    public static void main(String[] args) {
        // Example arrays as per your input
        double[] m0 = {0.00, 1.15, 1.24, 1.35, 1.54, 2.32, 2.85, 3.10, 3.40, 3.80, 4.10, 4.21, 4.44};
        double[] n0 = {0.00, 1.12, 1.34, 1.45, 2.54, 3.12, 3.57};

        // Get the last element of n[0]
        double lastElementOfN0 = n0[n0.length - 1];

        // Create a new array to store the results
        double[] p0 = filterArray(m0, lastElementOfN0);

        // Print the result
        System.out.print("p[0] = [");
        for (int i = 0; i < p0.length; i++) {
            System.out.print(p0[i]);
            if (i < p0.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Method to filter the array based on the last element of n[0]
    private static double[] filterArray(double[] array, double threshold) {
        int count = 0;
        // Count how many elements in array are less than or equal to threshold
        for (double value : array) {
            if (value <= threshold) {
                count++;
            } else {
                break; // Since the array is presumably sorted, we can break early
            }
        }

        // Create a new array with the counted size and fill it
        double[] result = new double[count];
        System.arraycopy(array, 0, result, 0, count);

        return result;
    }
}