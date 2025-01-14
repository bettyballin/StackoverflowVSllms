#define _USE_MATH_DEFINES // required to use M_PI without issues
#include <math.h>
#include <stdio.h>

int main() {
    double a = atan2(0, -1);
    printf("%f\n", a);
    return 0;
}