#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define PORT 8080 // Example port
#define BUFFER_SIZE 1024

int main() {
    int ConnectSocket, conn_status;
    struct sockaddr_in server_addr;
    const char *command = "PTZControl?pan=left&tilt=up"; // Example command

    // Create socket
    ConnectSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (ConnectSocket < 0) {
        perror("socket creation failed");
        exit(1);
    }

    // Set up server address
    server_addr.sin_family = AF_INET;
    inet_pton(AF_INET, "127.0.0.1", &server_addr.sin_addr); // Example IP address
    server_addr.sin_port = htons(PORT);

    // Connect to the server
    conn_status = connect(ConnectSocket, (struct sockaddr *)&server_addr, sizeof(server_addr));
    if (conn_status < 0) {
        perror("connection failed");
        exit(1);
    }

    // Send command
    send(ConnectSocket, command, (int)strlen(command), 0);

    // Shutdown the send half of the connection since we don't plan to send more data.
    shutdown(ConnectSocket, SHUT_WR);

    // Optionally, you might want to receive and print a response from the server.
    // For simplicity, this step is omitted.

    // Close the socket
    close(ConnectSocket);

    return 0;
}