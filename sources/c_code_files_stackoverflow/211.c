#include <stdio.h>
#include <math.h>

unsigned next_set_of_n_elements(unsigned x) 
{
    unsigned smallest, ripple, new_smallest, ones;

    if (x == 0) return 0;
    smallest     = (x & -x);
    ripple       = x + smallest;
    new_smallest = (ripple & -ripple);
    ones         = ((new_smallest/smallest) >> 1) - 1;
    return ripple | ones;
}

void test (void)
{
    int bits = 2;
    int a = pow(2, bits) - 1;
    int i;

    for (i = 0; i < 100; i++)
    {
        printf("next number is %d\n", a);
        a = next_set_of_n_elements(a);
    }
}

int main()
{
    test();
    return 0;
}