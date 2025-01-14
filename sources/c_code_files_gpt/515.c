#include <stdio.h>

unsigned int count_bit_transitions(unsigned int n) {
    // XOR n with a right-shifted version of itself
    unsigned int transitions = n ^ (n >> 1);

    // Count the number of set bits in the result
    unsigned int count = 0;
    while (transitions) {
        count += transitions & 1;
        transitions >>= 1;
    }

    return count;
}

int main() {
    unsigned int n1 = 0b00000000000000000000000000001010;
    unsigned int n2 = 0b00000000000000000000000000001001;
    
    printf("Number of transitions in %u: %u\n", n1, count_bit_transitions(n1));
    printf("Number of transitions in %u: %u\n", n2, count_bit_transitions(n2));
    
    return 0;
}