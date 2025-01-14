#include <stdio.h>

static double inner_function(double x) {
    // some code
    return x * x;
}

double outer_function(double x, double y) {
    double z = inner_function(x);
    return z + y;
}

int main() {
    printf("%lf\n", outer_function(2.0, 4.0));
    return 0;
}