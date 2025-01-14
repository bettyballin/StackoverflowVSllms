#include <windows.h>

DWORD WINAPI SecondaryThread(LPVOID lpParameter) {
    // thread function implementation
    return 0;
}

int main() {
    HANDLE hThread;
    DWORD dwGenericThreadID;
    LPVOID pis8 = NULL; // initialize pis8 to something

    hThread = CreateThread(NULL, 0, SecondaryThread, (LPVOID)pis8, 0, &dwGenericThreadID);

    // rest of the program implementation

    return 0;
}