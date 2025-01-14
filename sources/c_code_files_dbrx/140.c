#include <stdio.h>
#include <string.h>   //strlen
#include <stdlib.h>   //exit(0);
#include <arpa/inet.h>    //close
#include <unistd.h>  //write
#include <netdb.h>
#include <sys/socket.h>

void error(const char *msg) { 
    perror(msg); 
    exit(1); // Changed exit code to 1 to indicate an error
}

int main(int argc, char *argv[]) {
    int sockfd = socket(AF_INET, SOCK_STREAM, 0), newsockfd;
    struct sockaddr_in serv_addr, cli_addr;
    const unsigned short PORT = 3490; /* Port to listen on */
    char buffer[256];

    /* Set up the address structure */
    bzero((char *)&serv_addr, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(PORT);
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);

    /* Bind to the address and port with our socket */
    if (bind(sockfd, (struct sockaddr *) &serv_addr, sizeof(serv_addr)) < 0) {
        error("bind");
    }

    /* Create queue and start listening for clients */
    if (listen(sockfd, 10) < 0) {
        error("listen");
    }

    socklen_t clilen;
    clilen = sizeof(cli_addr);

    /* Wait for a client to connect */
    printf("Server is waiting for a client...\n");
    while ((newsockfd = accept(sockfd, (struct sockaddr *)&cli_addr, &clilen)) > 0) {
        // Accept the connection. Write is used to reply back to client
        printf("Server is connected with IP: %s and Port: %d...\n",
               inet_ntoa(cli_addr.sin_addr), ntohs(cli_addr.sin_port));
        printf("Here is the message received from %s:\n",
               inet_ntoa(cli_addr.sin_addr));

        bzero(buffer, 256); // Initialize buffer with zeros
        read(newsockfd, buffer, 255);
        write(newsockfd, "Hello", 5); // Changed to write 5 bytes
        close(newsockfd);
    }
    return 0;
}