#include <stdio.h>
#include <limits.h> // defines INT_MAX et al.

#define BYTE_MIN (-INT_MAX - 1)      /* minimum value of byte */
#define BYTE_MAX (INT_MAX / (int)sizeof(unsigned char))  /* largest positive value of byte */

typedef signed char Tbyte; // explicit type for a signed char/byte

int main() {
    printf("BYTE_MIN: %d\n", BYTE_MIN);
    printf("BYTE_MAX: %d\n", BYTE_MAX);
    return 0;
}