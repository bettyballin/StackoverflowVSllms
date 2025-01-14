#include <stdio.h>
#include <winsock2.h>

int main() {
    WSADATA wsaData;
    SOCKET ConnectSocket = INVALID_SOCKET;

    // Initialize Winsock
    WSAStartup(MAKEWORD(2,2), &wsaData);

    // Assume ConnectSocket is a valid socket connected to a server

    char recvbuf[512];
    int recvbuflen = 512;
    int bytesReceived = recv(ConnectSocket, recvbuf, recvbuflen, 0);
    if (bytesReceived > 0) {
        printf("Bytes received: %d\n", bytesReceived);
        printf("Data: %.*s\n", bytesReceived, recvbuf);
    }

    // Clean up
    WSACleanup();

    return 0;
}