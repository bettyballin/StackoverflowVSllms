#include <windows.h>

int main() {
    HDC hdc; // device context
    int iPixelFormat; // pixel format index
    PIXELFORMATDESCRIPTOR pfd; // pixel format descriptor
    int ret; // return value

    // Create a device context
    hdc = GetDC(NULL);
    if (hdc == NULL) {
        return 1;
    }

    // Set the pixel format index
    iPixelFormat = 1;

    // Describe the pixel format
    ret = DescribePixelFormat(hdc, iPixelFormat, sizeof(PIXELFORMATDESCRIPTOR), &pfd);
    if (ret == 0) {
        return 1;
    }

    // Print the pixel format descriptor
    printf("Pixel format descriptor:\n");
    printf("  Size: %d\n", pfd.nSize);
    printf("  Version: %d\n", pfd.nVersion);
    printf("  Flags: 0x%x\n", pfd.dwFlags);
    printf("  PixelType: %d\n", pfd.iPixelType);
    printf("  ColorBits: %d\n", pfd.cColorBits);
    printf("  RedBits: %d\n", pfd.cRedBits);
    printf("  RedShift: %d\n", pfd.cRedShift);
    printf("  GreenBits: %d\n", pfd.cGreenBits);
    printf("  GreenShift: %d\n", pfd.cGreenShift);
    printf("  BlueBits: %d\n", pfd.cBlueBits);
    printf("  BlueShift: %d\n", pfd.cBlueShift);
    printf("  AlphaBits: %d\n", pfd.cAlphaBits);
    printf("  AlphaShift: %d\n", pfd.cAlphaShift);
    printf("  AccumBits: %d\n", pfd.cAccumBits);
    printf("  AccumRedBits: %d\n", pfd.cAccumRedBits);
    printf("  AccumGreenBits: %d\n", pfd.cAccumGreenBits);
    printf("  AccumBlueBits: %d\n", pfd.cAccumBlueBits);
    printf("  AccumAlphaBits: %d\n", pfd.cAccumAlphaBits);
    printf("  DepthBits: %d\n", pfd.cDepthBits);
    printf("  StencilBits: %d\n", pfd.cStencilBits);
    printf("  AuxBuffers: %d\n", pfd.cAuxBuffers);
    printf("  LayerType: %d\n", pfd.iLayerType);
    printf("  Reserved: %d\n", pfd.bReserved);
    printf("  LayerMask: %d\n", pfd.dwLayerMask);
    printf("  VisibleMask: %d\n", pfd.dwVisibleMask);
    printf("  DamageMask: %d\n", pfd.dwDamageMask);

    // Release the device context
    ReleaseDC(NULL, hdc);

    return 0;
}