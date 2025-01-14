#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>

#define TCP_BlockSize 1024

int main() {
    int sock = 0; // This should be a valid socket descriptor in a real application.
    int len = 2048; // Example total length to receive.
    int currentlen = 0; // Current received length.
    char *buf = (char*)malloc(len); // Buffer to store received data.
    int to_rcv;
    int result;

    if (buf == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    to_rcv = (len - currentlen < TCP_BlockSize) ? len - currentlen : TCP_BlockSize;
    result = recv(sock, buf + currentlen, to_rcv, 0); // Added flags argument to recv().

    if (result < 0) {
        perror("recv");
    } else {
        printf("Received %d bytes.\n", result);
    }

    free(buf); // Free the allocated memory.

    return 0;
}