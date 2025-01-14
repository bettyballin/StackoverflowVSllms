#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/tcp.h>
#include <unistd.h>
#include <stdio.h> // Include stdio for perror

/* Function to set TCP keep-alive options */
void set_keepalive_options(int sockfd) {
    int keepalive = 1;  // Enable keepalive
    int keepidle = 60;  // Time (in seconds) before sending keepalive probes
    int keepinterval = 10;  // Interval (in seconds) between keepalive probes
    int keepcount = 5;  // Number of keepalive probes before declaring the connection dead

    // Set the keepalive option
    if (setsockopt(sockfd, SOL_SOCKET, SO_KEEPALIVE, &keepalive, sizeof(keepalive)) < 0) {
        perror("setsockopt(SO_KEEPALIVE) failed");
    }

    // Set the keepalive idle time
    if (setsockopt(sockfd, IPPROTO_TCP, TCP_KEEPIDLE, &keepidle, sizeof(keepidle)) < 0) {
        perror("setsockopt(TCP_KEEPIDLE) failed");
    }

    // Set the keepalive interval
    if (setsockopt(sockfd, IPPROTO_TCP, TCP_KEEPINTVL, &keepinterval, sizeof(keepinterval)) < 0) {
        perror("setsockopt(TCP_KEEPINTVL) failed");
    }

    // Set the keepalive probe count
    if (setsockopt(sockfd, IPPROTO_TCP, TCP_KEEPCNT, &keepcount, sizeof(keepcount)) < 0) {
        perror("setsockopt(TCP_KEEPCNT) failed");
    }
}

int main() {
    // Create a socket to test the function
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        return -1;
    }

    // Call the function to set keepalive options
    set_keepalive_options(sockfd);

    // Close the socket
    close(sockfd);

    return 0;
}