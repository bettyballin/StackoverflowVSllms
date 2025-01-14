#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/tcp.h>

int main() {
    int sockfd;
    struct sockaddr_in server_addr;
    struct tcp_md5sig md5sig;
    char *key = "your-md5-key"; // MD5 key

    // Create the socket
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Set up the server address
    memset(&server_addr, 0, sizeof(server_addr));
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(12345); // Server port
    server_addr.sin_addr.s_addr = inet_addr("127.0.0.1"); // Server IP

    // Set up the MD5 signature option
    memset(&md5sig, 0, sizeof(md5sig));
    md5sig.tcpm_keylen = strlen(key);
    memcpy(md5sig.tcpm_key, key, md5sig.tcpm_keylen);

    if (setsockopt(sockfd, IPPROTO_TCP, TCP_MD5SIG, &md5sig, sizeof(md5sig)) < 0) {
        perror("setsockopt(TCP_MD5SIG)");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    // Connect to the server
    if (connect(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("connect");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    // Place your send/receive socket code here

    // Close the socket
    close(sockfd);
    return 0;
}