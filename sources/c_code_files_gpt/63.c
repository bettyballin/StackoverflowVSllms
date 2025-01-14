#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <sys/select.h>
#include <errno.h> // Added for errno variable

int main(int argc, char *argv[]) {
    int server_fd, client_fd, port, max_sd;
    struct sockaddr_in server_addr, client_addr;
    fd_set readfds;
    socklen_t addr_len = sizeof(client_addr);
    char buffer[1024];
    
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <port>\n", argv[0]); // Added newline character
        exit(EXIT_FAILURE);
    }
    
    port = atoi(argv[1]);
    server_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (server_fd < 0) {
        perror("socket");
        exit(EXIT_FAILURE);
    }
    
    server_addr.sin_family = AF_INET;
    server_addr.sin_addr.s_addr = INADDR_ANY;
    server_addr.sin_port = htons(port);
    
    if (bind(server_fd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("bind");
        close(server_fd);
        exit(EXIT_FAILURE);
    }
    
    if (listen(server_fd, 5) < 0) {
        perror("listen");
        close(server_fd);
        exit(EXIT_FAILURE);
    }
    
    printf("Server listening on port %d\n", port); // Added newline character
    
    while (1) {
        FD_ZERO(&readfds);
        FD_SET(server_fd, &readfds);
        max_sd = server_fd;
        
        client_fd = accept(server_fd, (struct sockaddr *)&client_addr, &addr_len);
        if (client_fd < 0) {
            perror("accept");
            continue;
        }
        
        printf("New connection from %s:%d\n", inet_ntoa(client_addr.sin_addr), ntohs(client_addr.sin_port)); // Added newline character
        
        FD_SET(client_fd, &readfds);
        if (client_fd > max_sd) {
            max_sd = client_fd;
        }
        
        int activity = select(max_sd + 1, &readfds, NULL, NULL, NULL);
        if ((activity < 0) && (errno != EINTR)) {
            perror("select");
        }
        
        if (FD_ISSET(client_fd, &readfds)) {
            int valread = read(client_fd, buffer, sizeof(buffer));
            if (valread == 0) {
                // Connection closed
                printf("Client disconnected\n"); // Added newline character
                close(client_fd);
                FD_CLR(client_fd, &readfds);
            } else if (valread < 0) {
                perror("read");
                close(client_fd);
                FD_CLR(client_fd, &readfds);
            } else {
                buffer[valread] = '\0';
                printf("Received: %s\n", buffer); // Added newline character
            }
        }
    }
    
    close(server_fd);
    return 0;
}