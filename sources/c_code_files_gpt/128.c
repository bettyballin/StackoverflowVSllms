#include <openssl/rand.h>
#include <stdio.h>

int get_random_bytes(unsigned char *buf, int num) {
    if (RAND_bytes(buf, num) != 1) {
        // Handle error
        return -1;
    }
    return 0;
}

int main() {
    unsigned char buf[16]; // Example: get 16 random bytes
    int ret = get_random_bytes(buf, 16);
    if (ret == 0) {
        printf("Random bytes generated successfully.\n");
        // Print the first byte as an example
        printf("First byte: %02X\n", buf[0]);
    } else {
        printf("Failed to generate random bytes.\n");
    }
    return 0;
}