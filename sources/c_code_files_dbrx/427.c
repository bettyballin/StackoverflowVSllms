#include <windows.h>

int main() {
    HDC hdcScreen = GetDC(NULL);   // handle to the display device context
    HDC hdcCompatible = CreateCompatibleDC(hdcScreen);  // create a compatible DC
    HBITMAP bitmapToDraw, oldBitmap;
    HBITMAP maskMap;

    // ... initialize and select your bitmap into the compatible memory DC here.
    // Suppose maskMap is a handle to your monochrome DDB or DIB of type MM_ISOTROPIC that is not stretched in either direction (i.e., ratio = 1/1)

    int x, y, width, height, srcX, srcY, xMask, yMask;
    // Initialize variables...

    MaskBlt(hdcScreen, x, y, width, height, hdcCompatible, srcX, srcY, bitmapToDraw, 0, 0, maskMap, xMask, yMask, MERGEPAINT); // ROP code = `MAKEROP4(SRCCOPY,MERGEPAINT)` = `0xBBBB`

    ReleaseDC(NULL, hdcScreen);
    DeleteDC(hdcCompatible);

    return 0;
}