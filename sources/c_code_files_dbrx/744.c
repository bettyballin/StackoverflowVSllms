#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

int main() {
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket failed");
        return EXIT_FAILURE;
    }

    if (listen(sockfd, 10) < 0) {    // start listening with max. queue length 10
        perror("listen failed");
        return EXIT_FAILURE;
    }

    struct sockaddr_in addr; // placeholder for address information
    memset(&addr, '\0', sizeof(addr));  // clear the memory block to zero -> good practice
    int addrLen = sizeof(addr);        // set size of structure

    if (getsockname(sockfd, (struct sockaddr *)&addr, &addrLen) < 0) {    // read connected information
        perror("getsockname failed");     // print error code and message on terminal
    } else {                           // if no error occurrs
        printf("Client IP: %s\n", inet_ntoa(addr.sin_addr));  // address of client that is connected to the server socket descriptor
        printf("Port # of remote end-point: %d\n", ntohs(addr.sin_port)); // port number of this client
    }

    return 0;
}