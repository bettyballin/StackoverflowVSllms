#include <windows.h>

int main() {
    HDC hdc = GetDC(NULL); // Get the device context for the entire screen

    // Create a compatible bitmap with the same width and height as the screen
    int width = GetDeviceCaps(hdc, HORZRES);
    int height = GetDeviceCaps(hdc, VERTRES);
    HBITMAP hBitmap = CreateCompatibleBitmap(hdc, width, height);

    // Release the device context
    ReleaseDC(NULL, hdc);

    // Don't forget to delete the bitmap when you're done with it
    DeleteObject(hBitmap);

    return 0;
}