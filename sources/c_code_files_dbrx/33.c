#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
    int sockfd;
    struct sockaddr_in serv_addr;
    char buffer[256];
    char response[1024] = "";
    int n;

    // Create a socket
    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    serv_addr.sin_family = AF_INET;
    inet_pton(AF_INET, "93.184.216.34", &serv_addr.sin_addr); // replace with your target IP
    serv_addr.sin_port = htons(80);

    if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {
        perror("connect");
        exit(EXIT_FAILURE);
    }

    // Send GET request
    sprintf(buffer, "GET / HTTP/1.1\r\nHost: www.example.com\r\nConnection: close\r\nUser-Agent: QNX curl/7.68.0\r\nAccept: */*\r\n\r\n"); 
    n = write(sockfd, buffer, strlen(buffer));

    if (n < 0) {
        perror("write");
        exit(EXIT_FAILURE);
    }

    while ((n = read(sockfd, buffer, sizeof(buffer)-1)) > 0) {
        buffer[n] = '\0';
        strncat(response, buffer, sizeof(response)-strlen(response)-1); // append response to the string
        memset(&buffer[0], 0, sizeof(buffer));
    }
    close(sockfd);

    printf("%s", response);
    return EXIT_SUCCESS;
}