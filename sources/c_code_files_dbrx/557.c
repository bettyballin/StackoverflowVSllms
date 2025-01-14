#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define PORT 8080
#define BUFFER_SIZE 1024

int setup_socket() {
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        exit(1);
    }
    return sockfd;
}

void listen_on_socket(int sockfd) {
    struct sockaddr_in server_addr;
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(PORT);
    server_addr.sin_addr.s_addr = INADDR_ANY;

    if (bind(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("bind failed");
        exit(1);
    }

    if (listen(sockfd, 3) < 0) {
        perror("listen failed");
        exit(1);
    }
}

int accept_connection(int sockfd) {
    struct sockaddr_in client_addr;
    socklen_t client_len = sizeof(client_addr);
    int newfd = accept(sockfd, (struct sockaddr *)&client_addr, &client_len);
    if (newfd < 0) {
        perror("accept failed");
        exit(1);
    }
    return newfd;
}

int main() {
    int sockfd = setup_socket();
    listen_on_socket(sockfd);

    while (1) {
        int newfile_descriptor = accept_connection(sockfd);
        int connection_active = 1;

        while (connection_active) {
            int command;
            ssize_t bytes_read = read(newfile_descriptor, &command, sizeof(int));
            if (bytes_read < 0) {
                perror("read failed");
                connection_active = 0;
            } else if (bytes_read == 0) {
                // Client closed the connection
                connection_active = 0;
            } else {
                switch (command) {
                    // Add your command handling logic here
                    default:
                        printf("Unknown command: %d\n", command);
                }
            }
        }
        close(newfile_descriptor);
    }

    return 0;
}