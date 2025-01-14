#include <winsock2.h>
#include <ws2tcpip.h>
#include <stdio.h> // Include stdio.h for printf and fprintf

int main() {
    // Initialize Winsock
    WSADATA wsaData;
    int iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);
    if (iResult != 0) {
        printf("WSAStartup failed with error: %d\n", iResult);
        return 1;
    }

    int testIP(const char *hostname, const char* portnumber) {
        struct addrinfo hints;
        memset(&hints, 0, sizeof(hints));
        hints.ai_family = AF_UNSPEC; /* Allow IPv4 or IPv6 */
        hints.ai_socktype = SOCK_STREAM;
        int sfd, status;
        struct addrinfo *res;
        if ((status = getaddrinfo(hostname, portnumber, &hints, &res)) != 0) {
            printf("error at %d in getting address info", __LINE__);
            return -1;
        }
        sfd = socket(res->ai_family, res->ai_socktype, res->ai_protocol);

        if (connect(sfd, res->ai_addr, res->ai_addrlen)) {
            fprintf(stderr, "Server is unreachable (%d)\n", WSAGetLastError()); /* check your error code here. */
        } else {
            printf("Connection established\n");
        }
        freeaddrinfo(res);
        closesocket(sfd); // Close the socket
        return 0;
    }

    testIP("example.com", "80"); // Call the function with example parameters

    // Clean up Winsock
    WSACleanup();
    return 0;
}