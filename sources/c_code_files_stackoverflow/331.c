#include <stdio.h>

int ipow(int base, int exp)
{
    int result = 1;
    for (;;)
    {
        if (exp & 1)
            result *= base;
        exp >>= 1;
        if (!exp)
            break;
        base *= base;
    }

    return result;
}

int main()
{
    int base = 2;
    int exp = 3;
    int result = ipow(base, exp);
    printf("%d^%d = %d\n", base, exp, result);
    return 0;
}