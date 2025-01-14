#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/tcp.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <netinet/in.h>
#include <arpa/inet.h>

void send_message(int sockfd, const char *message, size_t length) {
    // Enable TCP_CORK
    int cork_on = 1;
    if (setsockopt(sockfd, IPPROTO_TCP, TCP_CORK, &cork_on, sizeof(cork_on)) < 0) {
        perror("setsockopt TCP_CORK on");
        return;
    }

    // Send the message
    if (send(sockfd, message, length, 0) < 0) {
        perror("send");
        return;
    }

    // Disable TCP_CORK to force sending the data
    int cork_off = 0;
    if (setsockopt(sockfd, IPPROTO_TCP, TCP_CORK, &cork_off, sizeof(cork_off)) < 0) {
        perror("setsockopt TCP_CORK off");
        return;
    }
}

int main() {
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        return 1;
    }

    struct sockaddr_in server_addr;
    server_addr.sin_family = AF_INET;
    inet_pton(AF_INET, "127.0.0.1", &(server_addr.sin_addr));
    server_addr.sin_port = htons(8080);

    if (connect(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("connection failed");
        return 1;
    }

    const char *message = "Your message here";
    
    send_message(sockfd, message, strlen(message));

    // Close the socket
    close(sockfd);
    return 0;
}