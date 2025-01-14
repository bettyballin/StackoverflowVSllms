#include <windows.h>
#include <stdio.h>

void callback(void) {
    printf("Callback function called\n");
}

int main() {
    // CreateThread requires a function pointer of type DWORD (__stdcall *)(void *)
    HANDLE hThread = CreateThread(NULL, 0, callback, NULL, 0, NULL);
    if (hThread == NULL) {
        printf("Failed to create thread\n");
    }
    return 0;
}