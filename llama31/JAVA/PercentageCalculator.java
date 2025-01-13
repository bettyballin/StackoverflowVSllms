public class PercentageCalculator {
    public static void main(String[] args) {
        long source = 4084094;
        long target = 4081313;
        double percentage = ((1 - (target / (double) source)) * 100);
        System.out.printf("%.4f%%%n", percentage); // Display percentage with 4 decimal places
    }
}