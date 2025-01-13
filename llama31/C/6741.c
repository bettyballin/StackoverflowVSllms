// win32_example.c\n#include <Windows.h>\n\nint main() {\n  HWND hwnd = FindWindow("MozillaWindowClass", NULL); // Find Firefox window\n  RECT rect;\n  GetWindowRect(hwnd, &rect);\n  HDC hdc = GetDC(hwnd);\n  HDC memdc = CreateCompatibleDC(hdc);\n  HBITMAP bitmap = CreateCompatibleBitmap(hdc, rect.right - rect.left, rect.bottom - rect.top);\n  SelectObject(memdc, bitmap);\n  PrintWindow(hwnd, memdc, PW_CLIENTONLY);\n  // Save or process the captured bitmap\n  DeleteDC(memdc);\n  ReleaseDC(hwnd, hdc);\n  return 0;\n}