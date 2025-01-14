#include <stdio.h>
#include <limits.h> // for CHAR_BIT

/* Function to reverse bits */
unsigned int reverseBits(unsigned int num) {
    unsigned int NO_OF_BITS = sizeof(num) * CHAR_BIT; // get number of bits in an integer, according to C standards
    unsigned int reverse_num = 0;

    // loop through all bits in the given number
    for (int i=0; i<NO_OF_BITS; i++) {
        /* Right shift the input and left shifts the temp variable. Bits will be copied from num to result */
        if( num & 1 )
            reverse_num |= 1 << ((sizeof(unsigned int) * CHAR_BIT - 1) - i); // copy current bit of num to reverse_num
        /* Right shift input by 1 */
        num >>= 1;
    }
    return reverse_num;
}

int main() {
    unsigned int num;
    printf("Enter a number: ");
    scanf("%u", &num);
    printf("Reversed bits: %u\n", reverseBits(num));
    return 0;
}