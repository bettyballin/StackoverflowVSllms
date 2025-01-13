#include <winsock2.h>\n#include <iostream>\n\n// Ensure WSACleanup is called per instance if WSAStartup is called.\nclass SocketManager {\npublic:\n    SocketManager() {\n        WSADATA wsaData;\n        int result = WSAStartup(MAKEWORD(2, 2), &wsaData);\n        if (result != 0) {\n            std::cerr << "WSAStartup failed: " << result << "\n";\n        }\n    }\n\n    ~SocketManager() {\n        WSACleanup();\n    }\n};\n\n// Example of using the SocketManager\nint main() {\n    SocketManager manager;\n    // Socket usage code here...\n    return 0;\n}