#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <dlfcn.h>

// Function definitions from the shared library
typedef int (*SomeFunctionType)(int);

int main() {
    int serverSocket, clientSocket;
    struct sockaddr_in serverAddr, clientAddr;
    socklen_t addrLen = sizeof(clientAddr);
    char buffer[1024];

    // Create a socket
    serverSocket = socket(AF_INET, SOCK_STREAM, 0);
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_addr.s_addr = INADDR_ANY;
    serverAddr.sin_port = htons(12345);
    
    // Bind and listen
    bind(serverSocket, (struct sockaddr*)&serverAddr, sizeof(serverAddr));
    listen(serverSocket, 3);

    // Load the shared library
    void* handle = dlopen("./path_to_your_so.so", RTLD_LAZY);
    if (handle == NULL) {
        printf("Failed to load the shared library\n");
        return 1;
    }

    // Get function pointer
    SomeFunctionType SomeFunction = (SomeFunctionType)dlsym(handle, "SomeFunction");
    if (SomeFunction == NULL) {
        printf("Failed to get function address\n");
        return 1;
    }

    // Accept a client socket
    clientSocket = accept(serverSocket, (struct sockaddr*)&clientAddr, &addrLen);

    // Communicate with the client
    recv(clientSocket, buffer, sizeof(buffer), 0);
    int param = atoi(buffer);
    int result = SomeFunction(param);
    sprintf(buffer, "%d", result);
    send(clientSocket, buffer, sizeof(buffer), 0);

    // Cleanup
    close(clientSocket);
    close(serverSocket);
    dlclose(handle);

    return 0;
}