#include <Windows.h>\n#include <WinSock2.h>\n#include <Ws2tcpip.h>\n#include <iphlpapi.h>\n\n#pragma comment(lib, "iphlpapi.lib")\n#pragma comment(lib, "ws2_32.lib")\n\nint main() {\n    // Initialize the Windows Sockets library\n    WSADATA wsaData;\n    WSAStartup(MAKEWORD(2, 2), &wsaData);\n\n    // Get the extended TCP table\n    MIB_TCPTABLE_OWNER_PID* pTcpTable;\n    DWORD dwSize = 0;\n    DWORD dwRetVal = 0;\n\n    dwRetVal = GetExtendedTcpTable(NULL, &dwSize, TRUE, AF_INET, TCP_TABLE_OWNER_PID_ALL, 0);\n    if (dwRetVal == ERROR_INSUFFICIENT_BUFFER) {\n        pTcpTable = (MIB_TCPTABLE_OWNER_PID*)malloc(dwSize);\n        if (pTcpTable == NULL) {\n            // Handle memory allocation error\n        }\n    } else {\n        // Handle GetExtendedTcpTable error\n    }\n\n    dwRetVal = GetExtendedTcpTable(pTcpTable, &dwSize, TRUE, AF_INET, TCP_TABLE_OWNER_PID_ALL, 0);\n    if (dwRetVal == NO_ERROR) {\n        // Iterate through the TCP connections\n        for (int i = 0; i < (int)pTcpTable->dwNumEntries; i++) {\n            MIB_TCPROW_OWNER_PID* pRow = &pTcpTable->table[i];\n            if (pRow->dwLocalPort == YOUR_PORT_NUMBER) {\n                // Get the PID of the process that connected to your port\n                DWORD dwPID = pRow->dwOwningPid;\n                // Handle the PID as needed\n                break;\n            }\n        }\n    } else {\n        // Handle GetExtendedTcpTable error\n    }\n\n    // Clean up\n    free(pTcpTable);\n    WSACleanup();\n\n    return 0;\n}