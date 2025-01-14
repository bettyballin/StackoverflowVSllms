#include <stdio.h>
#include <stdbool.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netinet/tcp.h>

int main() {
    bool optVal = true;
    socklen_t optLen = sizeof(optVal);
    int socket = 0; // replace with your actual socket

    if (setsockopt(socket, IPPROTO_TCP, TCP_NODELAY, &optVal, optLen) == 0) {
        printf("Success\n");
    }

    return 0;
}