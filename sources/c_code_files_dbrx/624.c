#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define ARRAY_LEN 10

int main() {
    // Sending side
    long sourceArray[ARRAY_LEN];
    long* sourceArrayPointer = sourceArray;
    int clientSocketFD = socket(AF_INET, SOCK_STREAM, 0);
    if (clientSocketFD < 0) {
        perror("socket creation failed");
        exit(1);
    }

    struct sockaddr_in serverAddress;
    serverAddress.sin_family = AF_INET;
    serverAddress.sin_port = htons(8080);
    inet_pton(AF_INET, "127.0.0.1", &serverAddress.sin_addr);

    if (connect(clientSocketFD, (struct sockaddr*)&serverAddress, sizeof(serverAddress)) < 0) {
        perror("connection failed");
        exit(1);
    }

    for (int i = 0; i < ARRAY_LEN; i++) {
        sourceArray[i] = sourceArrayPointer[i];
    }

    send(clientSocketFD, sourceArray, sizeof(long) * ARRAY_LEN, 0);

    // Receiving side
    int socketFD = socket(AF_INET, SOCK_STREAM, 0);
    if (socketFD < 0) {
        perror("socket creation failed");
        exit(1);
    }

    struct sockaddr_in serverAddress2;
    serverAddress2.sin_family = AF_INET;
    serverAddress2.sin_port = htons(8080);
    inet_pton(AF_INET, "127.0.0.1", &serverAddress2.sin_addr);

    if (bind(socketFD, (struct sockaddr*)&serverAddress2, sizeof(serverAddress2)) < 0) {
        perror("binding failed");
        exit(1);
    }

    if (listen(socketFD, 3) < 0) {
        perror("listening failed");
        exit(1);
    }

    struct sockaddr_in clientAddress;
    socklen_t clientAddressLength = sizeof(clientAddress);
    int newSocketFD = accept(socketFD, (struct sockaddr*)&clientAddress, &clientAddressLength);
    if (newSocketFD < 0) {
        perror("accept failed");
        exit(1);
    }

    long targetArray[ARRAY_LEN];
    size_t total_received = 0;
    while (total_received < ARRAY_LEN * sizeof(long)) {
        int result = read(newSocketFD, targetArray + total_received / sizeof(long), sizeof(long) * ARRAY_LEN - total_received);
        if (result > 0) {
            total_received += result;
        } else {
            // error handling code here if result is <= 0
            perror("read failed");
            exit(1);
        }
    }

    return 0;
}