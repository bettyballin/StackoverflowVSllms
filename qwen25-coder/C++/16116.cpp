#include <windows.h>\n#include <iostream>\n#include <string>\n\n// Function to convert hexadecimal layout ID to language name\nstd::string GetLanguageFromHex(HKL hkl) {\n    switch (hkl & 0xFFFF) {\n        case 1036: return "French";\n        case 1033: return "English - United States";\n        case 2057: return "English - United Kingdom";\n        // Add more cases as needed\n        default:   return "Unknown Language ID";\n    }\n}\n\nint main() {\n    DWORD processID;\n    HWND hwnd = GetForegroundWindow();\n    if (NULL != hwnd) {\n        GetWindowThreadProcessId(hwnd, &processID);\n        HKL hkl = GetKeyboardLayout(processID);\n        std::string languageName = GetLanguageFromHex(hkl);\n        std::cout << "Active Language: " << languageName << std::endl;\n    } else {\n        std::cout << "No active window found." << std::endl;\n    }\n    return 0;\n}