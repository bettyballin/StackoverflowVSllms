#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>

int main() {
    // Assuming myArrayFromFunction and targetArray are defined
    int myArrayFromFunction[10];
    int targetArray[10];

    // Assuming clientSocketFD and socketFD are defined
    int clientSocketFD = 0;
    int socketFD = 0;

    // Sending data from server side
    if (write(clientSocketFD, myArrayFromFunction, sizeof(myArrayFromFunction)) < 0) {
        perror("write");
        exit(EXIT_FAILURE);
    }

    // Receiving on client side
    if (read(socketFD, targetArray, sizeof(targetArray)) < 0) {
        perror("read");
        exit(EXIT_FAILURE);
    }

    return 0;
}