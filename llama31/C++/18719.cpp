#include <Windows.h>\n\nint main() {\n    // Enumerate raw input devices\n    UINT deviceCount;\n    GetRawInputDeviceList(NULL, &deviceCount, sizeof(RAWINPUTDEVICELIST));\n    RAWINPUTDEVICELIST* devices = new RAWINPUTDEVICELIST[deviceCount];\n    GetRawInputDeviceList(devices, &deviceCount, sizeof(RAWINPUTDEVICELIST));\n\n    // Iterate through devices and find keyboards\n    for (UINT i = 0; i < deviceCount; i++) {\n        if (devices[i].dwType == RIM_TYPEKEYBOARD) {\n            // Get device ID of keyboard\n            HANDLE hDevice = devices[i].hDevice;\n            // ...\n        }\n    }\n    delete[] devices;\n    return 0;\n}