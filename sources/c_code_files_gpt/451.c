#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <string.h>

#define PORT 8080
#define ARRAY_SIZE 5

void receive_integers(int sockfd, long *array, size_t size) {
    // Read the byte array from the socket
    ssize_t bytes_received = read(sockfd, array, size * sizeof(long));
    if (bytes_received < 0) {
        perror("read");
        exit(EXIT_FAILURE);
    }
}

int main() {
    int sockfd, newsockfd;
    struct sockaddr_in servaddr, cliaddr;
    socklen_t clilen;

    // Create socket
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }

    memset(&servaddr, 0, sizeof(servaddr));
    memset(&cliaddr, 0, sizeof(cliaddr));

    // Set server address
    servaddr.sin_family = AF_INET;
    servaddr.sin_port = htons(PORT);
    servaddr.sin_addr.s_addr = INADDR_ANY;

    // Bind socket
    if (bind(sockfd, (struct sockaddr *)&servaddr, sizeof(servaddr)) < 0) {
        perror("bind");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    // Listen for incoming connections
    if (listen(sockfd, 5) < 0) {
        perror("listen");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    // Accept a connection
    clilen = sizeof(cliaddr);
    newsockfd = accept(sockfd, (struct sockaddr *)&cliaddr, &clilen);
    if (newsockfd < 0) {
        perror("accept");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    // Buffer to store received integers
    long array[ARRAY_SIZE];

    // Receive the array
    receive_integers(newsockfd, array, ARRAY_SIZE);

    // Print received integers
    for (size_t i = 0; i < ARRAY_SIZE; i++) {
        printf("Received integer: %ld\n", array[i]);
    }

    // Close sockets
    close(newsockfd);
    close(sockfd);

    return 0;
}