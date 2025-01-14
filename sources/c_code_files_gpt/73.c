#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <openssl/rand.h>

int main() {
    unsigned char seed[32];
    
    // Generate a seed using OpenSSL's RAND_bytes (which uses /dev/urandom on Unix-like systems)
    if (RAND_bytes(seed, sizeof(seed)) != 1) {
        fprintf(stderr, "Error generating seed\n");
        return 1;
    }
    
    // Initialize srand with the seed
    srand((unsigned) seed[0] << 24 | (unsigned) seed[1] << 16 | (unsigned) seed[2] << 8 | (unsigned) seed[3]);

    // Example of generating a random number
    int random_number = rand();
    printf("Random number: %d\n", random_number);

    return 0;
}