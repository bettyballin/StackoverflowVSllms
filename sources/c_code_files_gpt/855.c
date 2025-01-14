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
    int server_fd, new_socket;
    struct sockaddr_in address;
    int addrlen = sizeof(address);
    struct DataPacket packet;

    // Create socket file descriptor
    if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) == 0) {
        perror("socket failed");
        exit(EXIT_FAILURE);
    }

    // Prepare the sockaddr_in structure
    address.sin_family = AF_INET;
    address.sin_addr.s_addr = INADDR_ANY;
    address.sin_port = htons(PORT);

    // Bind the socket
    if (bind(server_fd, (struct sockaddr *)&address, sizeof(address)) < 0) {
        perror("bind failed");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Listen for incoming connections
    if (listen(server_fd, 3) < 0) {
        perror("listen failed");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Accept an incoming connection
    if ((new_socket = accept(server_fd, (struct sockaddr *)&address, (socklen_t*)&addrlen)) < 0) {
        perror("accept failed");
        close(server_fd);
        exit(EXIT_FAILURE);
    }

    // Receive data packet from the client
    receive_packet(new_socket, &packet);
    printf("Received packet: ID=%d, Message=%s\n", packet.id, packet.message);

    // Modify the packet and send it back
    packet.id = 123;
    strcpy(packet.message, "Hello from server");
    send_packet(new_socket, &packet);

    close(new_socket);
    close(server_fd);
    return 0;
}