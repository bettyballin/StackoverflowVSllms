#include <stdlib.h>
#include <unistd.h>

#define ARRAY_LEN 4

int main() {
    long *targetArray = (long *)malloc(sizeof(long) * ARRAY_LEN);
    if (targetArray == NULL) {
        // Handle memory allocation failure
        return 1;
    }

    int socketFD = 0; // Replace with your actual socket file descriptor
    ssize_t bytesRead = read(socketFD, targetArray, sizeof(long) * ARRAY_LEN);
    if (bytesRead < 0) {
        // Handle read error
        free(targetArray);
        return 1;
    }

    // Don't forget to free the allocated memory when done
    free(targetArray);
    return 0;
}