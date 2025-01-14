#include <windows.h>
#include <stdio.h>

int main() {
    DWORD dwProcessId = GetCurrentProcessId(); // get process id for current process
    printf("Process ID : %d", dwProcessId);
    return 0;
}