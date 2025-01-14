#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <arpa/inet.h> // added for INADDR_ANY

int main(int argc, char *argv[]) {
    int sockfd, newsockfd, portno;
    socklen_t clilen;
    char buffer[256];
    struct sockaddr_in serv_addr, cli_addr;
    int n;

    if (argc < 2) {
        fprintf(stderr,"ERROR: No port provided\n");
        exit(1);
    }

    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        fprintf(stderr,"ERROR: cannot create socket\n");
        exit(1);
    }

    memset((char *) &serv_addr, '\0', sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    portno = atoi(argv[1]);
    serv_addr.sin_port = htons(portno);
    serv_addr.sin_addr.s_addr = INADDR_ANY;

    if (bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0) {
        fprintf(stderr,"ERROR: cannot bind\n");
        exit(1);
    }

    listen(sockfd,5);
    clilen = sizeof(cli_addr);
    newsockfd = accept(sockfd,(struct sockaddr *) &cli_addr,&clilen);
    if (newsockfd < 0) {
        fprintf(stderr,"ERROR: cannot accept connection\n");
        exit(1);
    }

    while (1) {
        memset((char*)buffer,0,256);
        n = read(newsockfd, buffer, 255);
        if (n < 0) {
            fprintf(stderr,"ERROR: cannot read from socket\n");
            return -1;
        } else if (n == 0) {
            break;
        }
        printf("Received message: %s\n", buffer);
    }
    close(newsockfd);
    close(sockfd);
    return 0;
}