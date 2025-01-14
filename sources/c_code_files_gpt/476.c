#include <stdio.h>
#include <stdlib.h>
#include <unistd.h> // for read()
#include <errno.h> // for perror()

#define ARRAY_LEN 262144

int main() {
    long targetArray[ARRAY_LEN];
    size_t total_bytes_to_receive = sizeof(long) * ARRAY_LEN;
    size_t bytes_received = 0;
    int socketFD = 0; // You need to initialize this with a valid file descriptor

    while (bytes_received < total_bytes_to_receive) {
        int result = read(socketFD, (char *)targetArray + bytes_received, total_bytes_to_receive - bytes_received);
        if (result < 0) {
            // Handle error
            perror("read");
            break;
        } else if (result == 0) {
            // Handle connection closed by the sender
            break;
        }
        bytes_received += result;
    }

    return 0;
}