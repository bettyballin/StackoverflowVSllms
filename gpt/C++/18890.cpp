#define WIN32_LEAN_AND_MEAN\n#include <windows.h>\n#include <iostream>\n\nclass Window {\npublic:\n    Window() : hwnd_(nullptr) {}\n\n    bool Create(LPCTSTR windowName, DWORD style, DWORD exStyle = 0, int x = CW_USEDEFAULT, int y = CW_USEDEFAULT,\n                int width = CW_USEDEFAULT, int height = CW_USEDEFAULT, HWND hWndParent = 0, HMENU hMenu = 0) {\n        WNDCLASS wc = {0};\n\n        wc.lpfnWndProc = Window::WndProc;\n        wc.hInstance = GetModuleHandle(nullptr);\n        wc.lpszClassName = TEXT("MyWindowClass");\n\n        RegisterClass(&wc);\n\n        hwnd_ = CreateWindowEx(exStyle, wc.lpszClassName, windowName, style, x, y, width, height, hWndParent, hMenu,\n                               GetModuleHandle(nullptr), this);\n\n        return hwnd_ != nullptr;\n    }\n\n    void Show(int nCmdShow) {\n        ShowWindow(hwnd_, nCmdShow);\n    }\n\n    void Run() {\n        MSG msg;\n        while (GetMessage(&msg, nullptr, 0, 0)) {\n            TranslateMessage(&msg);\n            DispatchMessage(&msg);\n        }\n    }\n\nprotected:\n    virtual LRESULT HandleMessage(UINT uMsg, WPARAM wParam, LPARAM lParam) {\n        switch (uMsg) {\n        case WM_PAINT:\n            PAINTSTRUCT ps;\n            HDC hdc;\n            hdc = BeginPaint(hwnd_, &ps);\n            TextOut(hdc, 5, 5, TEXT("Hello, Windows!"), 15);\n            EndPaint(hwnd_, &ps);\n            return 0;\n\n        case WM_DESTROY:\n            PostQuitMessage(0);\n            return 0;\n\n        default:\n            return DefWindowProc(hwnd_, uMsg, wParam, lParam);\n        }\n    }\n\nprivate:\n    static LRESULT CALLBACK WndProc(HWND hwnd, UINT uMsg, WPARAM wParam, LPARAM lParam) {\n        Window *pThis = nullptr;\n\n        if (uMsg == WM_NCCREATE) {\n            CREATESTRUCT *pCreate = (CREATESTRUCT *)lParam;\n            pThis = (Window *)pCreate->lpCreateParams;\n            SetWindowLongPtr(hwnd, GWLP_USERDATA, (LONG_PTR)pThis);\n\n            pThis->hwnd_ = hwnd;\n        } else {\n            pThis = (Window *)GetWindowLongPtr(hwnd, GWLP_USERDATA);\n        }\n\n        if (pThis) {\n            return pThis->HandleMessage(uMsg, wParam, lParam);\n        } else {\n            return DefWindowProc(hwnd, uMsg, wParam, lParam);\n        }\n    }\n\n    HWND hwnd_;\n};\n\nint main() {\n    Window win;\n\n    if (win.Create(TEXT("My Window"), WS_OVERLAPPEDWINDOW)) {\n        win.Show(SW_SHOWNORMAL);\n        win.Run();\n    }\n\n    return 0;\n}