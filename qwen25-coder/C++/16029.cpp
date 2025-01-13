LRESULT CALLBACK ConsoleWindowProc(HWND hwnd, UINT message, WPARAM wParam, LPARAM lParam) {\n    switch (message) {\n        case WM_DESTROY:\n            PostQuitMessage(0);\n            break;\n        default:\n            return DefWindowProc(hwnd, message, wParam, lParam);\n    }\n    return 0;\n}