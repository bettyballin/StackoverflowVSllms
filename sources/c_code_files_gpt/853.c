#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <netdb.h>

#define BUFFER_SIZE 4096

void error(const char *msg) {
    perror(msg);
    exit(1);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <URL>\n", argv[0]);
        exit(1);
    }

    char *hostname = "example.com"; // replace with your target hostname
    char *path = "/"; // replace with your target path, e.g., "/index.html"
    int port = 80;

    struct hostent *server;
    struct sockaddr_in serv_addr;
    int sockfd;
    char request[BUFFER_SIZE];
    char response[BUFFER_SIZE];

    // Get the server's IP address from its hostname
    server = gethostbyname(hostname);
    if (server == NULL) {
        error("ERROR, no such host");
    }

    // Create a socket
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        error("ERROR opening socket");
    }

    // Set up the server address struct
    bzero((char *) &serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    bcopy((char *)server->h_addr, (char *)&serv_addr.sin_addr.s_addr, server->h_length);
    serv_addr.sin_port = htons(port);

    // Connect to the server
    if (connect(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0) {
        error("ERROR connecting");
    }

    // Create the HTTP GET request
    snprintf(request, BUFFER_SIZE,
             "GET %s HTTP/1.1\r\n"
             "Host: %s\r\n"
             "Connection: close\r\n"
             "\r\n", path, hostname);

    // Send the request
    if (write(sockfd, request, strlen(request)) < 0) {
        error("ERROR writing to socket");
    }

    // Read the response
    int n;
    while ((n = read(sockfd, response, BUFFER_SIZE - 1)) > 0) {
        response[n] = '\0';
        printf("%s", response);
    }

    if (n < 0) {
        error("ERROR reading from socket");
    }

    // Close the socket
    close(sockfd);

    return 0;
}