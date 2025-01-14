#include <windows.h>

int main() {
    BITMAPINFOHEADER bmi = { sizeof(bmi) };
    bmi.biWidth = 20000;
    bmi.biHeight = 20000;
    bmi.biPlanes = 1;
    bmi.biBitCount = 16;
    HDC hdc = CreateCompatibleDC(NULL);
    BYTE* pbData = 0;
    HBITMAP hbm = CreateDIBSection(hdc, (BITMAPINFO*)&bmi, DIB_RGB_COLORS, (void**)&pbData, NULL, 0);
    DeleteObject(SelectObject(hdc, hbm));
    return 0;
}