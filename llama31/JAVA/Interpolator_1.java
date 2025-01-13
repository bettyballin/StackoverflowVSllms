public class Interpolator_1_1 {
    public int interpolate(int target) {
        int smallest = nextSmallest(target);
        int largest = nextLargest(target);
        return (int) ((target - smallest) / (double) (largest - smallest) * (largest - smallest) + smallest);
    }

    // Define the nextSmallest and nextLargest methods
    public int nextSmallest(int target) {
        // Implement the logic for nextSmallest
        return target - 1; // For example
    }

    public int nextLargest(int target) {
        // Implement the logic for nextLargest
        return target + 1; // For example
    }

    public static void main(String[] args) {
        Interpolator_1 interpolator = new Interpolator_1();
        int target = 10;
        int result = interpolator.interpolate(target);
        System.out.println("Interpolated value: " + result);
    }
}