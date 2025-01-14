#include <stdio.h>
#include <math.h>
#include <time.h>

#define TESTWITH(func) do { \
    clock_t time1 = clock(); \
    double result = func; \
    clock_t time2 = clock(); \
    double diff = (double)(time2 - time1) / CLOCKS_PER_SEC; \
    printf("Time taken by %s: %f seconds, Result: %f\n", #func, diff, result); \
} while (0)

int main()
{
    /* Actual tests start here. */
    TESTWITH(atan2(0, -1))
    TESTWITH(acos(-1))
    TESTWITH(2 * asin(1))
    TESTWITH(4 * atan2(1, 1))
    TESTWITH(4 * atan(1))

    return 0;
}