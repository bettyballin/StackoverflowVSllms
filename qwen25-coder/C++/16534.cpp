#include <iostream>\n#include <winsock2.h>\n#include <iphlpapi.h>\n#include <ws2tcpip.h>\n\n#pragma comment(lib, "iphlpapi.lib")\n\nint main() {\n    DWORD dwSize = 0;\n    MIB_TCPTABLE_OWNER_PID* pTcpTable = NULL;\n\n    // Get the required size for the TCP table\n    if (GetExtendedTcpTable(NULL, &dwSize, TRUE, AF_INET, TCP_TABLE_OWNER_PID_ALL, 0) == ERROR_INSUFFICIENT_BUFFER) {\n        pTcpTable = (MIB_TCPTABLE_OWNER_PID*)malloc(dwSize);\n        if (pTcpTable == NULL) return 1;\n    }\n\n    // Retrieve the TCP table\n    DWORD status = GetExtendedTcpTable(pTcpTable, &dwSize, TRUE, AF_INET, TCP_TABLE_OWNER_PID_ALL, 0);\n\n    if (status == ERROR_SUCCESS)\n    {\n        for (DWORD i = 0; i < pTcpTable->dwNumEntries; i++)\n        {\n            MIB_TCPROW_OWNER_PID tcpRow = pTcpTable->table[i];\n            char ipAddress[INET_ADDRSTRLEN];\n\n            // Convert the local IP address to a string\n            if (inet_ntop(AF_INET, &tcpRow.dwLocalAddr, ipAddress, INET_ADDRSTRLEN) != NULL)\n            {\n                std::cout << "Local Address: " << ipAddress \n                          << ", Local Port: " << ntohs(tcpRow.dwLocalPort) \n                          << ", State: " << tcpRow.dwState\n                          << ", PID: " << tcpRow.dwOwningPid << std::endl;\n            }\n        }\n    }\n\n    free(pTcpTable);\n    return 0;\n}