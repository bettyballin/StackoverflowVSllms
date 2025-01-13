#include <winsock2.h>\n#include <ws2tcpip.h>\n#include <iostream>\n\n#pragma comment(lib, "Ws2_32.lib")\n\nint main() {\n    WSADATA wsaData;\n    int iResult;\n\n    // Initialize Winsock\n    iResult = WSAStartup(MAKEWORD(2, 2), &wsaData);\n    if (iResult != NO_ERROR) {\n        std::cerr << "WSAStartup failed: " << iResult << std::endl;\n        return 1;\n    }\n\n    SOCKET SendSocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);\n    if (SendSocket == INVALID_SOCKET) {\n        std::cerr << "Error at socket(): " << WSAGetLastError() << std::endl;\n        WSACleanup();\n        return 1;\n    }\n\n    // Set up multicast group and port\n    sockaddr_in GroupSock;\n    char MulticastIP[] = "239.0.0.255"; // Example multicast address\n    int PortNo = 5004;\n\n    memset((char*)&GroupSock, 0, sizeof(GroupSock));\n    GroupSock.sin_family = AF_INET;\n    GroupSock.sin_port = htons(PortNo);\n    inet_pton(AF_INET, MulticastIP, &GroupSock.sin_addr);\n\n    // Set TTL so that messages go beyond local network\n    unsigned char ttl = 2; // Time-to-live for multicast, typically 16 to 32\n    setsockopt(SendSocket, IPPROTO_IP, IP_MULTICAST_TTL, (char*)&ttl, sizeof(ttl));\n\n    const int BUFFER_LEN = 512;\n    const char* SendBuf = "Hello from the Server!";\n    iResult = sendto(SendSocket, SendBuf, strlen(SendBuf), 0, (struct sockaddr*) &GroupSock, sizeof(GroupSock));\n    if (iResult == SOCKET_ERROR) {\n        std::cerr << "sendto failed with error: " << WSAGetLastError() << std::endl;\n        closesocket(SendSocket);\n        WSACleanup();\n        return 1;\n    }\n\n    // Close socket and clean up\n    closesocket(SendSocket);\n    WSACleanup();\n\n    return 0;\n}