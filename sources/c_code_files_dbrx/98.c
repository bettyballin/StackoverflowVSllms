#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int sockfd;
    struct sockaddr_in server_addr;
    char message1[] = "Hello, ";
    char message2[] = "World!";
    int length1 = strlen(message1);
    int length2 = strlen(message2);

    // Creating socket
    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
        perror("Socket creation failed");
        exit(EXIT_FAILURE);
    }

    // Setting up server address
    server_addr.sin_family = AF_INET;
    inet_pton(AF_INET, "127.0.0.1", &(server_addr.sin_addr)); // Assuming the server is on localhost
    server_addr.sin_port = htons(8080); // Assuming the server listens on port 8080

    // Connecting to the server
    if (connect(sockfd, (struct sockaddr*)&server_addr, sizeof(server_addr)) < 0) {
        perror("Connection failed");
        exit(EXIT_FAILURE);
    }

    // Sending messages
    if (send(sockfd, message1, length1, MSG_MORE) < 0) {
        perror("Failed to send first part of the message");
        exit(EXIT_FAILURE);
    }

    if (send(sockfd, message2, length2, 0) < 0) {
        perror("Failed to send second part of the message");
        exit(EXIT_FAILURE);
    }

    close(sockfd); // Close the socket

    return 0;
}