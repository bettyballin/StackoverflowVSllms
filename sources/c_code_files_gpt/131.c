#include <stdio.h>

void cordic(double theta, double *s, double *c, int n) {
    double power_of_two = 1.0;
    double angle = 0.0;
    double x = 1.0;
    double y = 0.0;
    double angles[] = {45.0, 26.565, 14.036, 7.125, 3.576, 1.789, 0.895, 0.448, 0.224, 0.112, 0.056, 0.028, 0.014, 0.007, 0.0035}; // Precomputed angle values

    for (int i = 0; i < n; ++i) {
        double x_new, y_new;
        double angle_shift = angles[i];
        if (theta < angle) {
            x_new = x - y * power_of_two;
            y_new = y + x * power_of_two;
            angle -= angle_shift;
        } else {
            x_new = x + y * power_of_two;
            y_new = y - x * power_of_two;
            angle += angle_shift;
        }
        x = x_new;
        y = y_new;
        power_of_two *= 0.5;
    }

    *c = x;
    *s = y;
}

int main() {
    double theta = 30.0; // example input
    double s, c;
    int n = 15; // example number of iterations
    cordic(theta, &s, &c, n);
    printf("sin(%.2f) = %.6f\n", theta, s);
    printf("cos(%.2f) = %.6f\n", theta, c);
    return 0;
}