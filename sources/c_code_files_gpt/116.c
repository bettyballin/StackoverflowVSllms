#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <netinet/ip.h>
#include <netinet/tcp.h>

// Define BUFSIZE
#define BUFSIZE 65536

// Define modify_packet function
void modify_packet(char *buffer, ssize_t len) {
    // Example modification: Add a signature to TCP payload
    struct ip *iph = (struct ip *) buffer;
    struct tcphdr *tcph = (struct tcphdr *) (buffer + iph->ip_hl * 4);
    char *payload = (char *) (buffer + iph->ip_hl * 4 + tcph->th_off * 4);

    // Modify payload here (example: append a signature)
    const char *signature = "SIGNATURE";
    strncat(payload, signature, BUFSIZE - len - 1);
    // Adjust IP and TCP header lengths and checksums as necessary
    // (left as an exercise)
}

int main() {
    int sockfd, n;
    char buffer[BUFSIZE];
    struct sockaddr_in sin;

    // Create a raw socket
    sockfd = socket(AF_INET, SOCK_RAW, IPPROTO_DIVERT);
    if (sockfd < 0) {
        perror("socket");
        exit(EXIT_FAILURE);
    }

    // Initialize sockaddr_in structure
    memset(&sin, 0, sizeof(sin));
    sin.sin_family = AF_INET;
    sin.sin_port = htons(12345); // Example port for divert socket
    sin.sin_addr.s_addr = htonl(INADDR_ANY);

    // Bind the socket to a port
    if (bind(sockfd, (struct sockaddr *) &sin, sizeof(sin)) < 0) {
        perror("bind");
        close(sockfd);
        exit(EXIT_FAILURE);
    }

    while (1) {
        // Receive data from the socket
        n = recvfrom(sockfd, buffer, BUFSIZE, 0, NULL, NULL);
        if (n < 0) {
            perror("recvfrom");
            close(sockfd);
            exit(EXIT_FAILURE);
        }

        // Modify the packet
        modify_packet(buffer, n);

        // Send the modified packet back
        if (sendto(sockfd, buffer, n, 0, (struct sockaddr *) &sin, sizeof(sin)) < 0) {
            perror("sendto");
            close(sockfd);
            exit(EXIT_FAILURE);
        }
    }

    // Close the socket
    close(sockfd);
    return 0;
}