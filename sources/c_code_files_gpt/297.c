#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <sys/select.h>
#include <errno.h> // Include errno.h for errno variable

#define PORT 8080

void setup_socket(int *server_fd, struct sockaddr_in *address) {
    int opt = 1;
    int addrlen = sizeof(*address);

    // Creating socket file descriptor
    if ((*server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0) {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }

    // Forcefully attaching socket to the port
    if (setsockopt(*server_fd, SOL_SOCKET, SO_REUSEADDR | SO_REUSEPORT, &opt, sizeof(opt))) {
        perror("setsockopt");
        exit(EXIT_FAILURE);
    }

    address->sin_family = AF_INET;
    address->sin_addr.s_addr = INADDR_ANY;
    address->sin_port = htons(PORT);

    // Binding the socket to the address
    if (bind(*server_fd, (struct sockaddr *)address, sizeof(*address)) < 0) {
        perror("bind failed");
        exit(EXIT_FAILURE);
    }

    // Start listening on the socket
    if (listen(*server_fd, 3) < 0) {
        perror("listen");
        exit(EXIT_FAILURE);
    }
}

int main() {
    int server_fd, new_socket;
    struct sockaddr_in address;
    int addrlen = sizeof(address);
    int command;

    setup_socket(&server_fd, &address);

    fd_set readfds;
    int max_sd;

    while (1) {
        // Clear the socket set
        FD_ZERO(&readfds);
        
        // Add server socket to set
        FD_SET(server_fd, &readfds);
        max_sd = server_fd;

        // Wait for an activity on one of the sockets
        int activity = select(max_sd + 1, &readfds, NULL, NULL, NULL);

        if ((activity < 0) && (errno != EINTR)) {
            perror("select error");
        }

        // If something happened on the server socket, then it means an incoming connection
        if (FD_ISSET(server_fd, &readfds)) {
            if ((new_socket = accept(server_fd, (struct sockaddr *)&address, (socklen_t*)&addrlen)) < 0) {
                perror("accept");
                exit(EXIT_FAILURE);
            }

            // Read the command from the new socket
            if (read(new_socket, &command, sizeof(int)) != sizeof(int)) {
                perror("read");
                close(new_socket);
                continue;
            }
            switch (command) {
                // Handle different commands here
                // ...
            }

            // Close the socket after handling the command
            close(new_socket);
        }
    }

    return 0;
}