#include <Windows.h>

int main() {
    HWND hWnd = GetDesktopWindow(); // Replace with the desired window handle
    DWORD processId;
    DWORD threadId = GetWindowThreadProcessId(hWnd, &processId);

    if (threadId != 0) {
        printf("Thread ID: %u\n", threadId);
        printf("Process ID: %u\n", processId);
    } else {
        printf("Failed to retrieve thread and process IDs\n");
    }

    return 0;
}