#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <netinet/in.h>
#include <netinet/sctp.h>

#define PORT 5000
#define BUFFER_SIZE 1024

int main() {
    int sockfd;
    struct sockaddr_in servaddr;
    char buffer[BUFFER_SIZE];

    // Create SCTP one-to-many socket
    sockfd = socket(AF_INET, SOCK_SEQPACKET, IPPROTO_SCTP);
    if (sockfd == -1) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    memset(&servaddr, 0, sizeof(servaddr));
    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr = INADDR_ANY;
    servaddr.sin_port = htons(PORT);

    // Bind the socket to the server address and port
    if (bind(sockfd, (struct sockaddr *)&servaddr, sizeof(servaddr)) == -1) {
        perror("bind");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    // Listen for incoming SCTP connections
    if (listen(sockfd, 5) == -1) {
        perror("listen");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    printf("SCTP server listening on port %d\n", PORT);

    while (1) {
        struct sockaddr_in cliaddr;
        socklen_t clilen = sizeof(cliaddr);
        struct sctp_sndrcvinfo sndrcvinfo;
        int flags = 0;

        // Receive a message from a client
        int recv_len = sctp_recvmsg(sockfd, buffer, BUFFER_SIZE, (struct sockaddr *)&cliaddr, &clilen, &sndrcvinfo, &flags);
        if (recv_len == -1) {
            perror("sctp_recvmsg");
            continue;
        }

        buffer[recv_len] = '\0';
        printf("Received message: %s\n", buffer);

        // Echo the message back to the client
        if (sctp_sendmsg(sockfd, buffer, recv_len, (struct sockaddr *)&cliaddr, clilen, sndrcvinfo.sinfo_ppid, sndrcvinfo.sinfo_flags, sndrcvinfo.sinfo_stream, 0, 0) == -1) {
            perror("sctp_sendmsg");
        }
    }

    close(sockfd);
    return 0;
}