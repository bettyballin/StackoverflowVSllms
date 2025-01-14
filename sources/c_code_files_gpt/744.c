#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <arpa/inet.h>
#include <unistd.h>

#define PORT 8080

struct DataPacket {
    int id;
    char message[256];
};

// Function to send the data packet
void send_packet(int socket, struct DataPacket *packet) {
    send(socket, packet, sizeof(struct DataPacket), 0);
}

// Function to receive the data packet
void receive_packet(int socket, struct DataPacket *packet) {
    recv(socket, packet, sizeof(struct DataPacket), 0);
}

int main() {
    int sock = 0;
    struct sockaddr_in serv_addr;
    struct DataPacket packet;

    // Create socket file descriptor
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
        perror("Socket creation error");
        return -1;
    }

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(PORT);

    // Convert IPv4 and IPv6 addresses from text to binary form
    if (inet_pton(AF_INET, "127.0.0.1", &serv_addr.sin_addr) <= 0) {
        perror("Invalid address/Address not supported");
        return -1;
    }

    // Connect to the server
    if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0) {
        perror("Connection Failed");
        return -1;
    }

    // Prepare and send a data packet
    packet.id = 1;
    strcpy(packet.message, "Hello from client");
    send_packet(sock, &packet);

    // Receive response from the server
    receive_packet(sock, &packet);
    printf("Received packet: ID=%d, Message=%s\n", packet.id, packet.message);

    close(sock);
    return 0;
}