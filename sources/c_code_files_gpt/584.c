#include <Windows.h>

int main() {
    HWND hWnd = /* handle to the window */;
    char buffer[256];
    int bufferSize = 256;

    GetWindowText(hWnd, buffer, bufferSize);

    // Do something with the retrieved text, e.g., print it
    printf("%s\n", buffer);

    return 0;
}