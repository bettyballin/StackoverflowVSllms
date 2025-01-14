#include <stdio.h>

unsigned int popCount(unsigned int number) {
    unsigned int x = number ^ (number >> 1);
	x &= 0x7f7f7f7f; // Removing upper bit for every nibble to remove dependency with next one.
	x *= 0x01010101; // Multiplication will propagate carries in right direction
    return (unsigned int)((x >> 24) + (x >> 16) + (x >> 8 ) + x);
}

int main() {
    unsigned int number = 15; // example input
    printf("Population count of %u: %u\n", number, popCount(number));
    return 0;
}