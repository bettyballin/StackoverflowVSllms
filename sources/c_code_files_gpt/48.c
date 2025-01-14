#include <stdlib.h>
#include <time.h>
#include <stdint.h>
#include <stdio.h> // added missing header for printf

typedef uint64_t ulong;

// Function to perform one step in the GF(2^M) field
ulong gf2step(ulong x, int bits, ulong p) {
    x = x << 1; // "Multiply" by x
    if (x & (1UL << bits)) {
        x ^= p; // Apply the modulo reduction using the polynomial p
    }
    return x;
}

// Function to generate a random value within the bounds in GF(2^M)
ulong gf2random(ulong low, ulong high, ulong p, int bits) {
    // Seed the random number generator
    srand((unsigned int)time(NULL));

    // Calculate the number of steps needed to span the range
    ulong range_size = 0;
    ulong val = low;
    do {
        range_size++;
        val = gf2step(val, bits, p);
    } while (val != low);

    // Generate a random step within the range
    ulong random_step = rand() % range_size;

    // Start from the low value and step forward the random number of steps
    ulong result = low;
    for (ulong i = 0; i < random_step; i++) {
        result = gf2step(result, bits, p);
    }

    return result;
}

int main() {
    ulong low = 12;
    ulong high = 13;
    ulong p = 19;
    int bits = 4; // Number of bits for the field elements

    ulong random_value = gf2random(low, high, p, bits);
    printf("Random value in GF(2^%d) between %lu and %lu: %lu\n", bits, low, high, random_value);

    return 0;
}