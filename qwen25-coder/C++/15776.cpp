#include <windows.h>\n#include <iostream>\n\nclass Window {\npublic:\n    LRESULT update(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam) {\n        // Dispatch messages to member functions\n        switch (msg) {\n            case WM_PAINT:\n                ondraw();\n                return 0;\n            case WM_LBUTTONDOWN:\n                onclick(GET_X_LPARAM(lParam), GET_Y_LPARAM(lParam));\n                return 0;\n            default:\n                return DefWindowProc(hwnd, msg, wParam, lParam);\n        }\n    }\n\n    void run() {\n        // Create window and message loop here\n        WNDCLASS wndclass{};\n        wndclass.lpfnWndProc = Window::static_update;\n        wndclass.hInstance = GetModuleHandle(NULL);\n        wndclass.lpszClassName = "MyWindowClass";\n        RegisterClass(&wndclass);\n\n        HWND hwnd = CreateWindowEx(\n            0, "MyWindowClass", "Test Window",\n            WS_OVERLAPPEDWINDOW,\n            CW_USEDEFAULT, CW_USEDEFAULT, CW_USEDEFAULT, CW_USEDEFAULT,\n            NULL, NULL, GetModuleHandle(NULL), this // Pass 'this' pointer\n        );\n\n        ShowWindow(hwnd, SW_SHOW);\n        UpdateWindow(hwnd);\n\n        MSG msg;\n        while (GetMessage(&msg, NULL, 0, 0)) {\n            TranslateMessage(&msg);\n            DispatchMessage(&msg);\n        }\n    }\n\nprotected:\n    virtual void onclick(int x, int y) {\n        std::cout << "Clicked at (" << x << ", " << y << ")" << std::endl;\n    }\n\n    virtual void ondraw() {\n        std::cout << "Drawing..." << std::endl;\n    }\n\nprivate:\n    static LRESULT CALLBACK static_update(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam) {\n        // Retrieve 'this' pointer from window handle\n        Window* myThis = reinterpret_cast<Window*>(GetWindowLongPtr(hwnd, GWLP_USERDATA));\n        if (myThis) {\n            return myThis->update(hwnd, msg, wParam, lParam);\n        }\n        return DefWindowProc(hwnd, msg, wParam, lParam);\n    }\n};\n\nint main() {\n    Window win;\n    win.run();\n}