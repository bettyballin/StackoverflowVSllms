#include <windows.h>
#include <stdio.h>

int main() {
    HANDLE hSemaphore = CreateSemaphore(
        NULL,           // default security attributes
        1,              // initial count
        1,              // maximum count
        NULL);          // unnamed semaphore

    if (hSemaphore == NULL) {
        printf("CreateSemaphore error: %d\n", GetLastError());
        return 1;
    }

    // Use the semaphore in your code...
    
    // Close the semaphore handle when done
    CloseHandle(hSemaphore);

    return 0;
}