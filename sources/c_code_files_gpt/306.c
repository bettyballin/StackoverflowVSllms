#include <math.h>
#include <stdio.h>
#include <time.h>

#define ITERS 10000000
#define TESTWITH(x) {                                                       \
    diff = 0.0;                                                             \
    time1 = clock();                                                        \
    for (i = 0; i < ITERS; ++i)                                             \
        diff += (x) - M_PI;                                                 \
    time2 = clock();                                                        \
    printf("%s\t=> %e, time => %f\n", #x, diff, diffclock(time2, time1));   \
}

static inline double diffclock(clock_t time1, clock_t time0)
{
    return (double) (time1 - time0) / CLOCKS_PER_SEC;
}

int main()
{
    int i;
    clock_t time1, time2;
    double diff;

    /* Actual tests start here. */
    TESTWITH(atan2(0, -1))
    TESTWITH(acos(-1))
    TESTWITH(2 * asin(1))
    TESTWITH(4 * atan2(1, 1))
    TESTWITH(4 * atan(1))

    return 0;
}