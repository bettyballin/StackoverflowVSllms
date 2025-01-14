#include <windows.h>

// Assuming these are defined elsewhere in your original code
// If not, you'll need to define them appropriately
#define IDC_GAMECONSOLE 100
HWND gameHwnd;
HINSTANCE hInst;

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
    // Initialize hInst
    hInst = hInstance;
    
    // Initialize gameHwnd
    // For demonstration purposes, let's assume it's the main window handle
    gameHwnd = CreateWindowEx(
        WS_EX_CLIENTEDGE,
        TEXT("STATIC"),
        TEXT("Game Window"),
        WS_OVERLAPPEDWINDOW,
        CW_USEDEFAULT, CW_USEDEFAULT, CW_USEDEFAULT, CW_USEDEFAULT,
        NULL, NULL, hInstance, NULL
    );

    if (gameHwnd == NULL)
    {
        MessageBox(NULL, TEXT("Failed to create game window"), TEXT("Error"), MB_ICONERROR);
        return 1;
    }

    // Your original line of code
    HWND hWndConsole = CreateWindow(TEXT("EDIT"), NULL, WS_CHILD | ES_MULTILINE | ES_AUTOVSCROLL | ES_READONLY, 500, 10, 300, 240, gameHwnd, (HMENU) IDC_GAMECONSOLE, hInstance, NULL);

    if (hWndConsole == NULL)
    {
        MessageBox(NULL, TEXT("Failed to create console window"), TEXT("Error"), MB_ICONERROR);
        return 1;
    }

    ShowWindow(gameHwnd, nCmdShow);
    UpdateWindow(gameHwnd);

    MSG msg;
    while (GetMessage(&msg, NULL, 0, 0))
    {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }

    return (int)msg.wParam;
}