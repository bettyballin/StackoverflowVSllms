#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>

int main() {
    int imageLength;
    char *imageData;

    // set imageLength and imageData
    imageLength = 10; // example length
    imageData = malloc(imageLength);
    strcpy(imageData, "example"); // example data

    int sock = socket(AF_INET, SOCK_STREAM, 0);
    if (sock == -1) {
        perror("socket creation failed");
        exit(1);
    }

    struct sockaddr_in server;
    server.sin_family = AF_INET;
    server.sin_port = htons(8080); // example port
    server.sin_addr.s_addr = inet_addr("127.0.0.1"); // example address

    if (connect(sock, (struct sockaddr *)&server, sizeof(server)) == -1) {
        perror("connection failed");
        exit(1);
    }

    send(sock, &imageLength, sizeof(int), 0);
    send(sock, imageData, imageLength, 0);

    close(sock);
    free(imageData);

    return 0;
}