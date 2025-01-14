#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <errno.h>

#define ARRAY_LEN 262144

// Assuming getSourceArray() is defined elsewhere
long *getSourceArray();

int main() {
    // Assuming clientSocketFD is defined elsewhere
    int clientSocketFD;

    long *sourceArrayPointer = getSourceArray();

    long sourceArray[ARRAY_LEN];
    for (int i = 0; i < ARRAY_LEN; i++) {
        sourceArray[i] = sourceArrayPointer[i];
    }

    size_t total_bytes_to_send = sizeof(long) * ARRAY_LEN;
    size_t bytes_sent = 0;
    while (bytes_sent < total_bytes_to_send) {
        int result = send(clientSocketFD, (char *)sourceArray + bytes_sent, total_bytes_to_send - bytes_sent, 0);
        if (result < 0) {
            // Handle error
            perror("send");
            break;
        }
        bytes_sent += result;
    }

    return 0;
}