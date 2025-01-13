#include <windows.h>\n#include <string>\n\nLRESULT CALLBACK WindowProc(HWND hwnd, UINT uMsg, WPARAM wParam, LPARAM lParam);\n\nHINSTANCE hInst;\nHWND hEdit, hButton;\n\nint WINAPI wWinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, PWSTR pCmdLine, int nCmdShow)\n{\n    hInst = hInstance;\n\n    // Register the window class.\n    const wchar_t CLASS_NAME[] = L"Sample Window Class";\n\n    WNDCLASS wc = {};\n\n    wc.lpfnWndProc = WindowProc;\n    wc.hInstance = hInstance;\n    wc.lpszClassName = CLASS_NAME;\n\n    RegisterClass(&wc);\n\n    // Create the window.\n    HWND hwnd = CreateWindowEx(\n        0,\n        CLASS_NAME,\n        L"Sample Window",\n        WS_OVERLAPPEDWINDOW,\n        CW_USEDEFAULT, CW_USEDEFAULT, CW_USEDEFAULT, CW_USEDEFAULT,\n        NULL,\n        NULL,\n        hInstance,\n        NULL\n    );\n\n    if (hwnd == NULL)\n    {\n        return 0;\n    }\n\n    ShowWindow(hwnd, nCmdShow);\n\n    // Run the message loop.\n    MSG msg = {};\n    while (GetMessage(&msg, NULL, 0, 0))\n    {\n        TranslateMessage(&msg);\n        DispatchMessage(&msg);\n    }\n\n    return 0;\n}\n\nLRESULT CALLBACK WindowProc(HWND hwnd, UINT uMsg, WPARAM wParam, LPARAM lParam)\n{\n    switch (uMsg)\n    {\n    case WM_CREATE:\n        hEdit = CreateWindowEx(\n            0,\n            L"EDIT",\n            L"",\n            ES_LEFT | WS_CHILD | WS_VISIBLE | WS_BORDER | WS_TABSTOP | ES_NUMBER,\n            85, 43,\n            90, 25,\n            hwnd,\n            (HMENU)1,\n            hInst,\n            NULL\n        );\n\n        hButton = CreateWindowEx(\n            0,\n            L"BUTTON",\n            L"OK",\n            WS_CHILD | WS_VISIBLE | WS_TABSTOP | BS_PUSHBUTTON,\n            85, 80,\n            90, 25,\n            hwnd,\n            (HMENU)2,\n            hInst,\n            NULL\n        );\n        EnableWindow(hButton, FALSE); // Initially disable the button\n        break;\n\n    case WM_COMMAND:\n        if (HIWORD(wParam) == EN_CHANGE && LOWORD(wParam) == 1)\n        {\n            int len = GetWindowTextLength(hEdit);\n            EnableWindow(hButton, len > 0);\n        }\n        else if (HIWORD(wParam) == BN_CLICKED && LOWORD(wParam) == 2)\n        {\n            int len = GetWindowTextLength(hEdit);\n            if (len == 0)\n            {\n                MessageBox(hwnd, L"Número no válido", L"Error", MB_ICONEXCLAMATION | MB_OK);\n            }\n            else\n            {\n                // Handle OK button click when the field is not empty\n            }\n        }\n        break;\n\n    case WM_DESTROY:\n        PostQuitMessage(0);\n        return 0;\n    }\n\n    return DefWindowProc(hwnd, uMsg, wParam, lParam);\n}