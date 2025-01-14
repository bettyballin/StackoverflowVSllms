#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/tcp.h>
#include <errno.h>

int main() {
    // Assuming sockfd is a valid socket file descriptor.
    // For demonstration purposes, let's create a simple socket.
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }

    int enable = 1;
    if (setsockopt(sockfd, IPPROTO_TCP, TCP_MD5SIG, &enable, sizeof(int)) < 0) {
        perror("setsockopt");
        return errno;
    }

    // Don't forget to close the socket when you're done.
    close(sockfd);

    return 0;
}