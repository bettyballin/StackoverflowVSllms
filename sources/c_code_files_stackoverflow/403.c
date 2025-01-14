#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define PORT 8080

int setup_socket() {
    int sockfd, new_fd;
    struct sockaddr_in my_addr;
    int yes = 1;

    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
        perror("socket");
        exit(1);
    }

    if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &yes, sizeof(int)) == -1) {
        perror("setsockopt");
        exit(1);
    }

    my_addr.sin_family = AF_INET;
    my_addr.sin_port = htons(PORT);
    inet_pton(AF_INET, "127.0.0.1", &(my_addr.sin_addr));

    if (bind(sockfd, (struct sockaddr *)&my_addr, sizeof(struct sockaddr)) == -1) {
        perror("bind");
        exit(1);
    }

    return sockfd;
}

int main() {
    int sockfd = setup_socket();
    listen(sockfd);

    while(1) {
        struct sockaddr_in their_addr;
        socklen_t sin_size = sizeof(struct sockaddr_in);
        int new_fd = accept(sockfd, (struct sockaddr *)&their_addr, &sin_size);

        if (new_fd == -1) {
            perror("accept");
            continue;
        }

        int command;
        int bytes_received = read(new_fd, &command, sizeof(int));

        while(bytes_received > 0) {
            switch(command) {
                // Add your cases here
                default:
                    printf("Unknown command: %d\n", command);
            }

            bytes_received = read(new_fd, &command, sizeof(int));
        }

        close(new_fd);
    }

    return 0;
}