#include <sys/random.h>
#include <stdio.h>

int main() {
    unsigned char buffer[10];
    int read_bytes = getrandom(buffer, sizeof(buffer), 0); // returns number of bytes obtained or negative error code on failure
    
    if (read_bytes < 0) {
        perror("getrandom");
        return 1;
    }

    printf("Obtained %d random bytes.\n", read_bytes);

    // Optionally, print the buffer
    printf("Random bytes: ");
    for (int i = 0; i < read_bytes; i++) {
        printf("%02x ", buffer[i]);
    }
    printf("\n");

    return 0;
}