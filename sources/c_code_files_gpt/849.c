#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <unistd.h> // Added for close() function

int main() {
    int sock;
    struct sockaddr_in server;
    char message[1024], response[1024];

    // Create socket
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock < 0) {
        perror("socket creation failed");
        return 1;
    }

    server.sin_addr.s_addr = inet_addr("127.0.0.1");
    server.sin_family = AF_INET;
    server.sin_port = htons(12345);

    // Connect to the server
    if (connect(sock, (struct sockaddr*)&server, sizeof(server)) < 0) {
        perror("connection failed");
        return 1;
    }

    // Send data to the server
    sprintf(message, "%d", 42); // Example parameter
    if (send(sock, message, strlen(message), 0) < 0) {
        perror("send failed");
        return 1;
    }

    // Receive response from the server
    if (recv(sock, response, sizeof(response), 0) < 0) {
        perror("receive failed");
        return 1;
    }
    printf("Received: %s\n", response); // Added newline character

    // Cleanup
    if (close(sock) < 0) {
        perror("close failed");
        return 1;
    }

    return 0;
}