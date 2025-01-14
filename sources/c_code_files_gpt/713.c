#include <stdio.h>
#include <winsock2.h>
#include <ws2tcpip.h>
#include <mstcpip.h>

// Define WSAGetLastError for Linux
#ifdef __linux__
#include <errno.h>
#define WSAGetLastError() errno
#endif

// Example function to flush a socket's send queue
void FlushSocket(SOCKET s) {
    DWORD bytesReturned;
    if (WSAIoctl(s, SIO_FLUSH, NULL, 0, NULL, 0, &bytesReturned, NULL, NULL) == SOCKET_ERROR) {
        printf("WSAIoctl failed with error: %d\n", WSAGetLastError());
    } else {
        printf("Socket send queue flushed.\n");
    }
}

int main() {
    // Initialize Winsock
    WSADATA wsaData;
    if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) {
        printf("WSAStartup failed with error: %d\n", WSAGetLastError());
        return 1;
    }

    // Create a socket
    SOCKET s = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (s == INVALID_SOCKET) {
        printf("socket failed with error: %d\n", WSAGetLastError());
        WSACleanup();
        return 1;
    }

    // Call the example function
    FlushSocket(s);

    // Clean up
    closesocket(s);
    WSACleanup();

    return 0;
}