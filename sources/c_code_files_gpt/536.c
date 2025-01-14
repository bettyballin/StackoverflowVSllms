#include <winsock2.h>
#include <windows.h>
#include <stdio.h>

int main()
{
    // Initialize Winsock
    WSADATA wsaData;
    int result = WSAStartup(MAKEWORD(2, 2), &wsaData);
    if (result != 0) {
        printf("WSAStartup failed: %d\n", result);
        return 1;
    }

    // Create a socket
    SOCKET sock = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP);
    if (sock == INVALID_SOCKET) {
        printf("Socket creation failed: %ld\n", WSAGetLastError());
        WSACleanup();
        return 1;
    }

    // Connect to the server
    sockaddr_in serverAddr;
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(12345); // Specify the port number
    serverAddr.sin_addr.s_addr = inet_addr("192.168.1.100"); // Specify the IP address

    result = connect(sock, (SOCKADDR*)&serverAddr, sizeof(serverAddr));
    if (result == SOCKET_ERROR) {
        printf("Connection failed: %ld\n", WSAGetLastError());
        closesocket(sock);
        WSACleanup();
        return 1;
    }

    // Read from virtual COM port and send data to the server
    HANDLE hCom = CreateFile(L"\\\\.\\COMx", GENERIC_READ | GENERIC_WRITE, 0, NULL, OPEN_EXISTING, 0, NULL);
    if (hCom == INVALID_HANDLE_VALUE) {
        printf("Failed to open COM port\n");
        closesocket(sock);
        WSACleanup();
        return 1;
    }

    char buffer[1024];
    DWORD bytesRead;
    while (ReadFile(hCom, buffer, sizeof(buffer), &bytesRead, NULL)) {
        send(sock, buffer, bytesRead, 0);
    }

    // Cleanup
    CloseHandle(hCom);
    closesocket(sock);
    WSACleanup();

    return 0;
}