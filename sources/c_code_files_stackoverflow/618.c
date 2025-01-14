#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <errno.h>

#define MAXDATASIZE 256 // Define the maximum data size for the buffer

int main() {
    int sockfd; // Assuming sockfd is a socket file descriptor
    char buf[MAXDATASIZE]; // Buffer to receive data
    int numbytes; // Number of bytes received

    // For demonstration purposes, let's assume we have a valid socket file descriptor.
    // In a real scenario, you would need to establish a connection or create a socket and bind it.
    // sockfd = socket(AF_INET, SOCK_STREAM, 0);
    // connect(sockfd, &server_address, sizeof server_address);

    while (1) {
        numbytes = recv(sockfd, buf, MAXDATASIZE-1, 0);
        if (numbytes == -1) {
            perror("recv");
            exit(1);
        }
        buf[numbytes] = '\0';
        printf("Count: %d, Error: %d, Received: %s\n", numbytes, errno, buf);
        // more code to react goes here
    }

    return 0;
}