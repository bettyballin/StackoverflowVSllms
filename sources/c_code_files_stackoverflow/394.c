#include <Windows.h>
#include <stdio.h>

int main() {
    HANDLE hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);
    DWORD fileType = GetFileType(hStdOut);

    printf("File type: %d\n", fileType);

    return 0;
}