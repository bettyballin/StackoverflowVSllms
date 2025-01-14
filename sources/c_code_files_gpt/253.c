#include <windows.h>
#include <iphlpapi.h>
#include <stdio.h>
#include <stdlib.h>
#include <winsock2.h>
#include <ws2tcpip.h>

#pragma comment(lib, "iphlpapi.lib")
#pragma comment(lib, "ws2_32.lib")

void EnumerateTcpSockets() {
    PMIB_TCPTABLE_OWNER_PID pTcpTable;
    DWORD dwSize = 0;
    DWORD dwRetVal = 0;

    pTcpTable = (MIB_TCPTABLE_OWNER_PID *)malloc(sizeof(MIB_TCPTABLE_OWNER_PID));
    if (pTcpTable == NULL) {
        printf("Error allocating memory\n");
        return;
    }

    dwSize = sizeof(MIB_TCPTABLE_OWNER_PID);
    if ((dwRetVal = GetExtendedTcpTable(pTcpTable, &dwSize, TRUE, AF_INET, TCP_TABLE_OWNER_PID_ALL, 0)) == ERROR_INSUFFICIENT_BUFFER) {
        free(pTcpTable);
        pTcpTable = (MIB_TCPTABLE_OWNER_PID *)malloc(dwSize);
        if (pTcpTable == NULL) {
            printf("Error allocating memory\n");
            return;
        }
    }

    if ((dwRetVal = GetExtendedTcpTable(pTcpTable, &dwSize, TRUE, AF_INET, TCP_TABLE_OWNER_PID_ALL, 0)) == NO_ERROR) {
        printf("\nTCP Connections:\n");
        for (int i = 0; i < (int)pTcpTable->dwNumEntries; i++) {
            printf("PID: %lu, Local Addr: %s:%d, Remote Addr: %s:%d, State: %d\n",
                   pTcpTable->table[i].dwOwningPid,
                   inet_ntoa(*(struct in_addr *)&pTcpTable->table[i].dwLocalAddr),
                   ntohs((u_short)pTcpTable->table[i].dwLocalPort),
                   inet_ntoa(*(struct in_addr *)&pTcpTable->table[i].dwRemoteAddr),
                   ntohs((u_short)pTcpTable->table[i].dwRemotePort),
                   pTcpTable->table[i].dwState);
        }
    } else {
        printf("GetExtendedTcpTable failed with %d\n", dwRetVal);
    }

    if (pTcpTable != NULL) {
        free(pTcpTable);
        pTcpTable = NULL;
    }
}

int main() {
    WSADATA wsaData;
    if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) {
        printf("WSAStartup failed with error %d\n", WSAGetLastError());
        return 1;
    }

    EnumerateTcpSockets();

    WSACleanup();
    return 0;
}