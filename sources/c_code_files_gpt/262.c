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

void receive_packet(int sockfd) {
    Packet packet;
    struct sockaddr_in src_addr;
    socklen_t addr_len = sizeof(struct sockaddr_in);
    struct timeval recv_time, prev_recv_time, prev_send_time;
    int first_packet = 1;

    while (1) {
        // Receive the packet
        recvfrom(sockfd, &packet, sizeof(Packet), 0, (struct sockaddr *)&src_addr, &addr_len);
        
        // Get receive timestamp
        gettimeofday(&recv_time, NULL);
        
        if (!first_packet) {
            // Calculate send and receive differences
            long send_diff = (packet.timestamp.tv_sec - prev_send_time.tv_sec) * 1000000L + (packet.timestamp.tv_usec - prev_send_time.tv_usec);
            long recv_diff = (recv_time.tv_sec - prev_recv_time.tv_sec) * 1000000L + (recv_time.tv_usec - prev_recv_time.tv_usec);
            
            // Calculate IPDV
            long ipdv = recv_diff - send_diff;
            
            printf("Packet Delay Variation (IPDV): %ld microseconds\n", ipdv); // Fixed formatting
        } else {
            first_packet = 0;
        }
        
        // Save current timestamps for next calculation
        prev_send_time = packet.timestamp;
        prev_recv_time = recv_time;
    }
}

int main() {
    int sockfd;
    struct sockaddr_in server_addr;

    // Create a UDP socket
    sockfd = socket(AF_INET, SOCK_DGRAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        exit(1);
    }

    // Set up server address
    server_addr.sin_family = AF_INET;
    server_addr.sin_port = htons(8080); // Choose a port
    inet_pton(AF_INET, "127.0.0.1", &server_addr.sin_addr); // Choose an address

    // Bind the socket to the address and port
    if (bind(sockfd, (struct sockaddr *)&server_addr, sizeof(server_addr)) < 0) {
        perror("bind failed");
        exit(1);
    }

    receive_packet(sockfd);

    return 0;
}