#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <errno.h>

int main() {
    int mySocket;
    struct linger so_linger;

    // Create a socket
    mySocket = socket(AF_INET, SOCK_STREAM, 0);
    if (mySocket < 0) {
        perror("socket creation failed");
        exit(1);
    }

    so_linger.l_onoff = 1; // enable option
    so_linger.l_linger = 0; // waits for zero seconds

    if (setsockopt(mySocket, SOL_SOCKET, SO_LINGER, &so_linger, sizeof so_linger) != 0){
        perror("setsockopt");
        close(mySocket); // Close the socket before exiting
        exit(1);
    }

    printf("SO_LINGER option set successfully.\n");

    // Don't forget to close the socket when you're done with it
    close(mySocket);

    return 0;
}