#include <Windows.h>\n\nint main() {\n    // Get the handle to the target process's main window\n    HWND hWnd = FindWindow(NULL, "Target Window Title");\n\n    if (hWnd != NULL) {\n        // Send the WM_CLOSE message to the window with a timeout\n        SendMessageTimeout(hWnd, WM_CLOSE, 0, 0, SMTO_ABORTIFHUNG, 3000, NULL);\n    }\n\n    return 0;\n}