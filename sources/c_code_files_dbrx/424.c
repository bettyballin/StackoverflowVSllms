#include <stdio.h>

int reverseBits(unsigned int num, int n) {
    unsigned int rev = num & ((1 << n) - 1); // Mask out the first n bits of num
    unsigned int temp, reverse_num = 0;
    for (temp = rev; temp != 0; temp >>= 1){
        reverse_num = (reverse_num << 1) | (temp & 1); // Reverse the bit pattern.
    }
    return reverse_num;
}

int main() {
    unsigned int num = 18; // Example number
    int n = 5; // Number of bits to consider
    printf("Reversed bits of %u for %d bits: %u\n", num, n, reverseBits(num, n));
    return 0;
}