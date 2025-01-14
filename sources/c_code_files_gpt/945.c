#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/ip.h> // IP_DONTFRAG
#include <stdio.h>
#include <unistd.h> // close function

int main() {
    int sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        return 1;
    }

    int optval = 1; // Enable DF flag
    if (setsockopt(sockfd, IPPROTO_IP, IP_DONTFRAG, &optval, sizeof(optval)) < 0) {
        perror("setsockopt failed");
        return 1;
    }

    // Your code to use the socket...

    // Close the socket
    close(sockfd);
    return 0;
}