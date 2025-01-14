#include <winsock2.h>
#include <ws2tcpip.h>
#include <wspiapi.h>
#include <stdio.h> // Added for printf function

void printError(const char * msg) // Added function definition for printError
{
    printf("%s\n", msg);
}

void tryconnect(const char * host, const char * port)
{
    SOCKET Socket = INVALID_SOCKET;
    struct addrinfo *resAddrInfo = NULL;
    struct addrinfo *ptr = NULL;
    struct addrinfo hints;
    int result = 0;

    printf("Connecting to %s:%s\n", host, port); // Added newline character

    ZeroMemory(&hints, sizeof(hints));
    hints.ai_family = AF_UNSPEC;
    hints.ai_socktype = SOCK_STREAM;
    hints.ai_protocol = IPPROTO_TCP;

    result = getaddrinfo(host, port, &hints, &resAddrInfo);
    if (result != 0)
    {
        printError("getaddrinfo failed");
        return;
    }

    ptr = resAddrInfo;
    Socket = WSASocket(ptr->ai_family, ptr->ai_socktype, ptr->ai_protocol, NULL, 0, WSA_FLAG_OVERLAPPED);
    if (Socket == INVALID_SOCKET)
    {
        printError("Error Creating Socket");
        freeaddrinfo(resAddrInfo);
        return;
    }

    result = WSAConnect(Socket, ptr->ai_addr, (int)ptr->ai_addrlen, NULL, NULL, NULL, NULL);
    if (result != 0)
    {
        printError("Error Connecting");
        closesocket(Socket);
        freeaddrinfo(resAddrInfo);
        return;
    }

    freeaddrinfo(resAddrInfo);
    printf("Success!\n"); // Added newline character
}

int main() // Added main function
{
    WSADATA wsaData;
    if (WSAStartup(MAKEWORD(2,2), &wsaData) != 0)
    {
        printf("WSAStartup failed\n");
        return 1;
    }

    tryconnect("example.com", "80"); // Call tryconnect function

    WSACleanup();
    return 0;
}