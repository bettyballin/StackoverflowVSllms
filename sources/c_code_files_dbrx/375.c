#include <Windows.h>
#include <iphlpapi.h>
#include <stdio.h>

void GetVPNProcessStatistics(ULONG family) {
    ULONG length = 0;
    PMIB_TCPTABLE myTable = NULL;

    if (GetExtendedTcpTable(myTable, &length, true, family /* AF_INET for IPv4, AF_INET6 for IPv6*/, TCP_TABLE_OWNER_PID_ALL, 0)) { 
        // this will populate the myTable structure containing extended TCP connection statistics including process information
        // TODO: add error handling here using GetLastError()
        printf("GetExtendedTcpTable failed with error: %d\n", GetLastError());
    }
}

int main() {
    GetVPNProcessStatistics(AF_INET);
    return 0;
}