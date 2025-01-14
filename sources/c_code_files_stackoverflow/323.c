#include <stdio.h>
#include <math.h>

int main() {
    int i = 0x3ff00000; // example value for i
    double offset = pow(2, (i >> 20) - 0x3ff) * (((i & 0xfffff) + 0x100000) / (double) 0x100000);
    printf("%f\n", offset);
    return 0;
}