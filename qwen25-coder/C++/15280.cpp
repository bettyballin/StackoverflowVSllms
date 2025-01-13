#include <windows.h>\n#include <iostream>\n\nLRESULT CALLBACK WndProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam) {\n    switch (msg) {\n        case WM_INPUT: {\n            RAWINPUT raw;\n            UINT cbSize = sizeof(RAWINPUTHEADER);\n            UINT dwSize;\n\n            if (!GetRawInputData((HRAWINPUT)lParam, RID_INPUT, &raw.data, &dwSize, cbSize)) {\n                std::cerr << "GetRawInputData failed" << std::endl;\n                return -1;\n            }\n\n            if (raw.header.dwType == RIM_TYPEKEYBOARD) {\n                HANDLE hDevice = raw.header.hDevice;\n                RID_DEVICE_INFO rdi;\n                rdi.cbSize = sizeof(RID_DEVICE_INFO);\n\n                UINT cbRequired;\n\n                if (GetRawInputDeviceInfo(hDevice, RIDI_DEVICEINFO, &rdi, &cbRequired)) {\n                    std::cout << "Device Type: " << rdi.dwType << std::endl;\n                    // You can use this device info to distinguish keyboards\n                }\n            }\n\n            return DefWindowProc(hwnd, msg, wParam, lParam);\n        }\n        case WM_DESTROY:\n            PostQuitMessage(0);\n            break;\n        default:\n            return DefWindowProc(hwnd, msg, wParam, lParam);\n    }\n    return 0;\n}\n\nint WINAPI WinMain(HINSTANCE hInstance, HINSTANCE, LPSTR, int nCmdShow) {\n    WNDCLASSEX wcex{};\n    HWND hwnd;\n    MSG msg;\n\n    wcex.cbSize = sizeof(WNDCLASSEX);\n    wcex.lpfnWndProc = WndProc;\n    wcex.hInstance = hInstance;\n    wcex.lpszClassName = L"KeyboardInput";\n\n    RegisterClassEx(&wcex);\n\n    hwnd = CreateWindow(L"KeyboardInput", L"Raw Input Test", WS_OVERLAPPEDWINDOW,\n                      CW_USEDEFAULT, 0, CW_USEDEFAULT, 0, nullptr, nullptr, hInstance, nullptr);\n\n    ShowWindow(hwnd, nCmdShow);\n    UpdateWindow(hwnd);\n\n    RAWINPUTDEVICE Rid[1];\n    Rid[0].usUsagePage = 0x01; // HID_USAGE_PAGE_GENERIC\n    Rid[0].usUsage = 0x06;     // HID_USAGE_KEYBOARD\n    Rid[0].dwFlags = RIDEV_INPUTSINK;\n    Rid[0].hwndTarget = hwnd;\n\n    if (!RegisterRawInputDevices(Rid, 1, sizeof(RIDDEVICE))) {\n        std::cerr << "RegisterRawInputDevices failed" << std::endl;\n        return -1;\n    }\n\n    while (GetMessage(&msg, nullptr, 0, 0)) {\n        TranslateMessage(&msg);\n        DispatchMessage(&msg);\n    }\n}