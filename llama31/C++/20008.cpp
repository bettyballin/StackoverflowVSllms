#include <Windows.h>\n#include <Winnetwk.h>\n\nint main() {\n    char buf[MAX_PATH];\n    GetModuleFileName(NULL, buf, sizeof(buf));\n\n    // Convert UNC path to drive letter path\n    char driveLetter[MAX_PATH];\n    DWORD dwResult = WNetGetConnection(buf, driveLetter, sizeof(driveLetter));\n    if (dwResult == NO_ERROR) {\n        // Use the drive letter path\n        printf("Drive letter path: %s\n", driveLetter);\n    } else {\n        // Handle error\n    }\n\n    return 0;\n}