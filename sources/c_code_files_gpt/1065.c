#include <stdio.h>
#include <sys/socket.h>
#include <unistd.h>

#define ARRAY_LEN 4

int main() {
    long targetArray[ARRAY_LEN];
    int socketFD = 0; // replace with a valid socket file descriptor
    ssize_t bytes_read = read(socketFD, targetArray, sizeof(long) * ARRAY_LEN);

    if (bytes_read != sizeof(long) * ARRAY_LEN) {
        perror("read");
        return 1;
    }

    // Print the received data for verification
    for (int i = 0; i < ARRAY_LEN; i++) {
        printf("Received targetArray[%d]: %ld\n", i, targetArray[i]);
    }

    return 0;
}