#include <windows.h>

// Define the window handle for the OK button
HWND hOkButton;

// Define the window handle for the edit control
HWND hwndEdit;

// Define the IDC_MYEDIT constant
#define IDC_MYEDIT 100

// WndProc Event Handler Function
LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam)
{
    switch (message)
    {
        case WM_COMMAND:
            switch (HIWORD(wParam))
            {
                case EN_CHANGE: // Triggered on each character input in the edit control
                    if (LOWORD(wParam) == IDC_MYEDIT) { // Check that this is your specific edit box
                        int len = Edit_GetTextLength(hwndEdit); // Get length of characters entered to check if empty.

                        // Enable OK button if input is not empty, otherwise disable it.
                        BOOL enableOk = (len > 0) ? TRUE : FALSE;
                        EnableWindow(hOkButton, enableOk);
                    }
                break;
            }
        break;
    }
    return DefWindowProc(hWnd, message, wParam, lParam);
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
    // Register the window class
    WNDCLASSEX wc = {0};
    wc.cbSize = sizeof(WNDCLASSEX);
    wc.style = 0;
    wc.lpfnWndProc = WndProc;
    wc.cbClsExtra = 0;
    wc.cbWndExtra = 0;
    wc.hInstance = hInstance;
    wc.hIcon = LoadIcon(NULL, IDI_APPLICATION);
    wc.hCursor = LoadCursor(NULL, IDC_ARROW);
    wc.hbrBackground = (HBRUSH)(COLOR_WINDOW+1);
    wc.lpszMenuName = NULL;
    wc.lpszClassName = "MyClass";
    wc.hIconSm = LoadIcon(NULL, IDI_APPLICATION);
    RegisterClassEx(&wc);

    // Create the window
    HWND hWnd = CreateWindowEx(0, "MyClass", "My Window", WS_OVERLAPPEDWINDOW, CW_USEDEFAULT, CW_USEDEFAULT, 300, 200, NULL, NULL, hInstance, NULL);
    ShowWindow(hWnd, nCmdShow);
    UpdateWindow(hWnd);

    // Create the edit control and OK button
    hwndEdit = CreateWindowEx(0, "EDIT", "", WS_CHILD | WS_VISIBLE | WS_BORDER, 10, 10, 200, 20, hWnd, (HMENU)IDC_MYEDIT, hInstance, NULL);
    hOkButton = CreateWindowEx(0, "BUTTON", "OK", WS_CHILD | WS_VISIBLE | WS_DISABLED, 220, 10, 60, 20, hWnd, NULL, hInstance, NULL);

    // Run the message loop
    MSG msg = {0};
    while (GetMessage(&msg, NULL, 0, 0) > 0)
    {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }
    return msg.wParam;
}