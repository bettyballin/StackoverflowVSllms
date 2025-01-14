#if defined(__GNUC__) && (defined(__i386__) || defined(__amd64__))
#include <stdio.h>

double fldpi()
{
    double pi;
    asm volatile("fldpi" : "=t" (pi));
    return pi;
}

int main()
{
    double pi = fldpi();
    printf("The value of pi is: %f\n", pi);
    return 0;
}
#endif