#include <windows.h>
#include <htmlhelp.h>

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
    HWND m_hWnd = CreateWindow("STATIC", "Help", WS_OVERLAPPEDWINDOW, CW_USEDEFAULT, CW_USEDEFAULT, 300, 200, NULL, NULL, hInstance, NULL);
    ShowWindow(m_hWnd, nCmdShow);
    UpdateWindow(m_hWnd);

    HtmlHelp(m_hWnd, "Help.chm", HH_DISPLAY_TOPIC, NULL);

    MSG msg;
    while (GetMessage(&msg, NULL, 0, 0))
    {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }

    return 0;
}