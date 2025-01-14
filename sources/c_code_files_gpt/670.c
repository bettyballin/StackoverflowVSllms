#include <stdio.h>

short f(short x)
{
    return x;
}

int main()
{
    long x = 0x10000007;   // bigger than short
    printf("%d\n", (int)f(x));  // explicit cast to avoid warning
    return 0;
}