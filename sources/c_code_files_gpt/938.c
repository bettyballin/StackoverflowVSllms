#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <unistd.h>

int main() {
    int server_fd, new_socket;
    struct sockaddr address;
    socklen_t addrlen = sizeof(address);

    // Assuming server_fd is a socket file descriptor that has been set up
    // and bound to a specific address and port.
    // For demonstration purposes, let's just create a basic socket.
    server_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (server_fd < 0) {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }

    // Listen for incoming connections. Note: This requires a call to bind() first,
    // which is omitted here for brevity. Ensure you bind the socket to an address and port.
    if (listen(server_fd, 3) < 0) {
        perror("listen failed");
        exit(EXIT_FAILURE);
    }

    printf("Listening for incoming connections...\n");

    new_socket = accept(server_fd, (struct sockaddr *)&address, (socklen_t*)&addrlen);
    if (new_socket < 0) {
        perror("accept failed");
        exit(EXIT_FAILURE);
    }

    printf("Connection accepted...\n");

    // Don't forget to close sockets when you're done to free up resources.
    close(new_socket);
    close(server_fd);

    return 0;
}