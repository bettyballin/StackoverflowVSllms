import java.lang.String;
public class BinomialApproximation {

    public static double cdf(double p, int s, int n) {
        // Mean and standard deviation of binomial distribution
        double mean = n * p;
        double stdDev = Math.sqrt(n * p * (1 - p));

        // Continuity correction: subtract 0.5 if calculating "less than or equal to" in a continuous distribution
        double zScoreLowerBound = (s + 0.5 - mean) / stdDev;

        return cumulativeNormalDistribution(zScoreLowerBound);
    }

    private static double cumulativeNormalDistribution(double z) {
        // Coefficients for the error function approximation
        double b1 = 0.319381530;
        double b2 = -0.356563782;
        double b3 = 1.781477937;
        double b4 = -1.821255978;
        double b5 = 1.330274429;

        // Calculate the cumulative distribution function
        if (z >= 0.0) {
            double t = 1.0 / (1.0 + 0.2316419 * z);
            return 1.0 - (((((b5 * t + b4) * t + b3) * t + b2) * t + b1) * t) *
                    Math.exp(-z * z / 2.0);
        }
        else {
            double t = 1.0 / (1.0 - 0.2316419 * z);
            return ((((b5 * t + b4) * t + b3) * t + b2) * t + b1) *
                    Math.exp(-z * z / 2.0);
        }
    }

    public static void main(String[] args) {
        double p = 0.3;
        int s = 20; // or 40 for the second case
        int n = 100;

        double probability = cdf(p, s, n);
        System.out.println("Approximate Probability: " + probability);
    }
}