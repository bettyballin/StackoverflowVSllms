#include <Windows.h>\n#include <Shlobj.h>\n\nint main() {\n    TCHAR szPath[MAX_PATH];\n    HRESULT hr = SHGetFolderPath(NULL, CSIDL_LOCAL_APPDATA, NULL, 0, szPath);\n    if (SUCCEEDED(hr)) {\n        // Use the retrieved path to save and read data\n        // e.g., CreateDirectory, CreateFile, WriteFile, ReadFile\n    }\n    return 0;\n}