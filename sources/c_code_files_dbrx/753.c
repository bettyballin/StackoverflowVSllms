#include <windows.h>

// Define constants
#define TOOLBAR_WIDTH 400
#define TOOLBAR_HEIGHT 50

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow) {
    // Initialize variables
    HWND hWnd = CreateWindow("STATIC", "Toolbar", WS_OVERLAPPEDWINDOW, 0, 0, 0, 0, NULL, NULL, hInstance, NULL);
    APPBARDATA AppBarData;
    AppBarData.hWnd = hWnd;

    // Determine system metrics
    int padding = GetSystemMetrics(SM_CXBORDER) + GetSystemMetrics(SM_CYFRAME);

    // Define rectangle
    RECT rect;
    rect.top = 0;
    rect.left = 0;
    rect.right = TOOLBAR_WIDTH + padding * 2; // Add extra padding on width
    rect.bottom = TOOLBAR_HEIGHT + padding * 2; // Add extra padding on height

    // Set new dimensions for your application window
    SetWindowPos(AppBarData.hWnd, HWND_TOP, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top, SWP_SHOWWINDOW);

    // Run the message loop
    MSG msg;
    while (GetMessage(&msg, NULL, 0, 0)) {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }

    return 0;
}