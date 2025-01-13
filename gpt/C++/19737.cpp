#include <windows.h>\n#include <iostream>\n\nvoid PrintProcessStartTime(HANDLE hProcess)\n{\n    FILETIME creationTime, exitTime, kernelTime, userTime;\n\n    if (GetProcessTimes(hProcess, &creationTime, &exitTime, &kernelTime, &userTime))\n    {\n        SYSTEMTIME sysTime;\n        FileTimeToSystemTime(&creationTime, &sysTime);\n        std::cout << "Process Start Time: "\n                  << sysTime.wYear << "-"\n                  << sysTime.wMonth << "-"\n                  << sysTime.wDay << " "\n                  << sysTime.wHour << ":"\n                  << sysTime.wMinute << ":"\n                  << sysTime.wSecond << "."\n                  << sysTime.wMilliseconds\n                  << std::endl;\n    }\n    else\n    {\n        std::cerr << "Failed to get process times." << std::endl;\n    }\n}\n\nint main()\n{\n    HANDLE hProcess = GetCurrentProcess();\n    PrintProcessStartTime(hProcess);\n    return 0;\n}