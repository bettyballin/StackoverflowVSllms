#include <windows.h>
#include <stdio.h> // Include this for printf

int main() {
    HDC hdc = GetDC(NULL); // Get DC for entire desktop (all monitors)
    int logPixX = GetDeviceCaps(hdc, LOGPIXELSX);
    ReleaseDC(NULL, hdc);
    printf("LOGPIXELSX: %d\n", logPixX); // Added newline character
    return 0; // It's a good practice to return an integer from main
}