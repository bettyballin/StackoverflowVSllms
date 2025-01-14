#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <errno.h>

#define MAXDATASIZE 100 // Define the maximum data size
#define PORT "3490"     // Define the port to use (this is just an example)

int main() {
    int sockfd;  // Define the socket file descriptor
    char buf[MAXDATASIZE]; // Define the buffer to receive data
    int numbytes; // Define the variable to hold the number of bytes received

    // Assuming sockfd has been initialized and connected to a server
    // For the sake of completeness and making this code executable, we'll create a simple connection.
    // This is a very basic example and does not include error checking for brevity.
    struct sockaddr_in server_addr;
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(atoi(PORT));
    inet_pton(AF_INET, "127.0.0.1", &server_addr.sin_addr); // Assuming the server is on the same machine
    connect(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr));

    while (1) {
        numbytes = recv(sockfd, buf, MAXDATASIZE-1, 0);

        // Check for errors and handle them accordingly. For example:
        if (numbytes == -1) {
            perror("recv");
            close(sockfd);         // Close the socket file descriptor
            exit(EXIT_FAILURE);    // Exit with a failure code
        } else if (numbytes == 0) {
            printf("Peer closed connection\n");   // Connection was gracefully closed, stop receiving.
            break;                               // You may want to close the socket and exit here depending on your requirements.
        } else {
            buf[numbytes] = '\0';             // Only add null-terminator if data was successfully received.
            printf("Received: %s\n", buf);
            // more code to react goes here
        }
    }

    close(sockfd); // Close the socket
    return 0;
}