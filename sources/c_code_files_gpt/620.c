#include <sys/socket.h>
#include <sys/un.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int main() {
    int sockfd;
    struct sockaddr_un server_addr, client_addr;
    char buffer[256];
    ssize_t n;

    // Create socket
    sockfd = socket(AF_UNIX, SOCK_DGRAM, 0);
    if (sockfd < 0) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Server address
    memset(&server_addr, 0, sizeof(server_addr));
    server_addr.sun_family = AF_UNIX;
    strncpy(server_addr.sun_path, "/tmp/my_server_socket", sizeof(server_addr.sun_path) - 1);

    // Client address (abstract)
    memset(&client_addr, 0, sizeof(client_addr));
    client_addr.sun_family = AF_UNIX;
    snprintf(client_addr.sun_path + 1, sizeof(client_addr.sun_path) - 2, "%d", getpid());
    
    // Bind client socket to the unique abstract address
    if (bind(sockfd, (struct sockaddr *) &client_addr, sizeof(client_addr)) < 0) {
        perror("bind");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    // Send a message to the server
    const char *msg = "Hello, server!";
    n = sendto(sockfd, msg, strlen(msg), 0, (struct sockaddr *) &server_addr, sizeof(server_addr));
    if (n < 0) {
        perror("sendto");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    // Receive response from the server
    n = recvfrom(sockfd, buffer, sizeof(buffer) - 1, 0, NULL, NULL);
    if (n < 0) {
        perror("recvfrom");
        close(sockfd);
        exit(EXIT_FAILURE);
    }
    buffer[n] = '\0';
    printf("Received: %s\n", buffer); // Added newline character

    close(sockfd);
    return 0;
}