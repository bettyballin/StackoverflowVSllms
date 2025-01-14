#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define TCP_BlockSize 1024

int main() {
    int sock, len, currentLen;
    char *buf;
    struct sockaddr_in server_addr;
    socklen_t server_len = sizeof(server_addr);

    // Sample values for demonstration
    len = 2048;
    currentLen = 0;
    buf = malloc(len);

    // Assuming a socket has been created and connected to a server
    sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock < 0) {
        perror("socket creation failed");
        exit(EXIT_FAILURE);
    }

    server_addr.sin_family = AF_INET;
    inet_pton(AF_INET, "127.0.0.1", &server_addr.sin_addr); // Assuming server is on localhost
    server_addr.sin_port = htons(8080); // Assuming server is listening on port 8080

    if (connect(sock, (struct sockaddr *)&server_addr, server_len) < 0) {
        perror("connection failed");
        exit(EXIT_FAILURE);
    }

    while (currentLen < len) {
        int nLeftToRead = len - currentLen; // Calculate remaining bytes to read.
        int bytesReceived;

        if (nLeftToRead < TCP_BlockSize) {
            bytesReceived = recv(sock, buf + currentLen, nLeftToRead, 0); // Request exactly what's left.
        } else {
            bytesReceived = recv(sock, buf + currentLen, TCP_BlockSize, 0); // Otherwise request full buffer size.
        }

        if (bytesReceived < 0) {
            perror("recv failed");
            break;
        } else if (bytesReceived == 0) {
            printf("Connection closed by the server\n");
            break;
        }

        currentLen += bytesReceived;
    }

    close(sock);
    free(buf);
    return 0;
}