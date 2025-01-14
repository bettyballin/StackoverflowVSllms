#include <stdio.h>
#include <gsl/gsl_cdf.h>

int main() {
    double P = 0.95;  // Example: 95% of the distribution within [-a, a]
    double a = gsl_cdf_ugaussian_Pinv((1 + P) / 2);  // Find the critical value a for the given P

    double mean = 0;
    double std_deviation = a;  // For a standard normal distribution, mean = 0 and std_dev = 1

    printf("Standard Deviation: %f\n", std_deviation);
    return 0;
}