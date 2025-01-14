#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
#include <arpa/inet.h>
#include <sys/socket.h> // Added for socket functionality

// Define the packet structure
typedef struct {
    struct timeval timestamp;
    char data[256];  // Adjust size as needed
} Packet;

void send_packet(int sockfd, struct sockaddr_in *dest_addr) {
    Packet packet;
    
    // Get the current timestamp
    gettimeofday(&packet.timestamp, NULL);
    
    // Fill packet data
    strcpy(packet.data, "Hello, this is a test packet!");
    
    // Send the packet
    sendto(sockfd, &packet, sizeof(Packet), 0, (struct sockaddr *)dest_addr, sizeof(struct sockaddr_in));
}

int main() {
    int sockfd;
    struct sockaddr_in dest_addr;

    // Create a socket
    sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        exit(1);
    }

    // Set up destination address
    dest_addr.sin_family = AF_INET;
    dest_addr.sin_port = htons(12345); // Replace with desired port number
    inet_pton(AF_INET, "127.0.0.1", &dest_addr.sin_addr); // Replace with desired IP address

    send_packet(sockfd, &dest_addr);

    close(sockfd);
    return 0;
}