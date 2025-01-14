#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define MAXDATASIZE 1024 // maximum buffer size

int main(int argc, char *argv[]) {
    int sockfd, numbytes;
    char buf[MAXDATASIZE];
    struct sockaddr_in server_addr;

    if (argc != 3) {
        fprintf(stderr, "Usage: %s <server_ip> <port>\n", argv[0]);
        exit(1);
    }

    // Create socket
    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
        perror("socket");
        exit(1);
    }

    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(atoi(argv[2]));
    server_addr.sin_addr.s_addr = inet_addr(argv[1]);
    memset(&(server_addr.sin_zero), '\0', 8);

    // Connect to server
    if (connect(sockfd, (struct sockaddr *)&server_addr, sizeof(struct sockaddr)) == -1) {
        perror("connect");
        close(sockfd);
        exit(1);
    }

    // Send initial information to server
    const char *initial_msg = "Hello Server!";
    if (send(sockfd, initial_msg, strlen(initial_msg), 0) == -1) {
        perror("send");
        close(sockfd);
        exit(1);
    }

    // Continuous listening loop
    while (1) {
        numbytes = recv(sockfd, buf, MAXDATASIZE - 1, 0);
        if (numbytes == -1) {
            perror("recv");
            close(sockfd);
            exit(1);
        } else if (numbytes == 0) {
            printf("Connection closed by server\n");
            break;
        }

        buf[numbytes] = '\0';
        printf("Received: %s\n", buf);

        // More code to react to the received message goes here
    }

    close(sockfd);
    return 0;
}