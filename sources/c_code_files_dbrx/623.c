#include <stdio.h>
#include <stdint.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <linux/ip.h>
#include <linux/tcp.h>

// Define the calculate_isn function
uint32_t calculate_isn() {
    return 12345; // Replace with your own ISN calculation algorithm
}

int main() {
    // Assume next_seqno is initialized with ISN before first packet send
    uint32_t next_seqno = calculate_isn();
    uint32_t ackno;  // Acknowledgement number of received packet, to send in outgoing packet

    // Create a socket
    int sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0) {
        perror("socket creation failed");
        return -1;
    }

    struct sockaddr_in serv_addr;
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(8080); // Replace with your destination port
    inet_pton(AF_INET, "127.0.0.1", &(serv_addr.sin_addr)); // Replace with your destination IP

    // Connect to the server
    if (connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {
        perror("connect failed");
        return -1;
    }

    while (1) { // Replace with your own condition for packet transmission
        uint16_t len = 1024; // Replace with your own packet length
        char buffer[len];
        struct tcphdr *tcph = (struct tcphdr *)buffer;

        /* Fill the TCP Header */
        tcph->source = htons(8081); // Replace with your source port
        tcph->dest = htons(8080); // Replace with your destination port
        tcph->seq = htonl(next_seqno); // Set Sequence Number as current seq no.
        tcph->ack_seq = htonl(ackno); // Set Acknowledgement number.
        /* And so on, fill rest of the header...*/

        // Send packet here
        send(sockfd, buffer, len, 0); // send call to transmit your data.

        // Update seq no and ack no with size of sent/received buffer for next transmission.
        next_seqno += len;
        uint32_t ack = ntohl(*((uint32_t *)(buffer + sizeof(struct ethhdr) + sizeof(struct iphdr)))); // assuming you got a packet on socket sockfd and stored it in buffer, read the sequence number from the data received.
        /* You have to update your seqno using ackno of received data packet, usually it would be - next_seqno =  received ack + size_of _received_packet;*/
    }

    return 0;
}