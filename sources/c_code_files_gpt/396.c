#include <stdio.h>
    #include <inttypes.h>

    volatile uint32_t i;

    int main(void)
    {
        if (i == 64738)
            return 0;
        else
            return 1;
    }