#include <windows.h>

int main() {
    HANDLE hMapFile = CreateFileMapping(INVALID_HANDLE_VALUE, NULL, PAGE_READWRITE, 0, 4096, "Global\\MySharedMemory");
    // Additional code to handle the file mapping handle...
    return 0;
}