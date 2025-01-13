#include <windows.h>\n\nvoid SetProcessToSingleCPU() {\n    HANDLE hCurrentProc = GetCurrentProcess();\n    DWORD_PTR processAffinityMask;\n    DWORD_PTR systemAffinityMask;\n\n    if (GetProcessAffinityMask(hCurrentProc, &processAffinityMask, &systemAffinityMask)) {\n        // Set the process to use only one CPU core\n        DWORD_PTR newAffinityMask = 1; // Use the least significant bit for single-core usage\n        SetProcessAffinityMask(hCurrentProc, newAffinityMask);\n    }\n}