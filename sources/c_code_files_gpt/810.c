#include <windows.h>
#include <stdio.h>

#define BUFFER_SIZE 256

int main() {
    HANDLE handle1;
    LPVOID hView;
    char *data = "Hello from C program";

    handle1 = CreateFileMapping(
        INVALID_HANDLE_VALUE, NULL, PAGE_READWRITE, 0, sizeof(char) * BUFFER_SIZE, "my_foo");

    if (handle1 == NULL) {
        printf("Could not create file mapping object (%d).\n", GetLastError());
        return 1;
    }

    hView = MapViewOfFile(handle1, FILE_MAP_ALL_ACCESS, 0, 0, BUFFER_SIZE);

    if (hView == NULL) {
        printf("Could not map view of file (%d).\n", GetLastError());
        CloseHandle(handle1);
        return 1;
    }

    memcpy(hView, data, strlen(data) + 1);

    // Keep the program running to maintain the shared memory
    printf("Press any key to exit...\n");
    getchar();

    UnmapViewOfFile(hView);
    CloseHandle(handle1);

    return 0;
}