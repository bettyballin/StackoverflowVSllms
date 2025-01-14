public class Main {
    // Total number of combinations for n characters
    int totalCombinations(int n) {
        return (int)Math.pow(2, n - 1);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(obj.totalCombinations(4)); // Output: 8
    }
}