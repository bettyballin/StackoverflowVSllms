#include <windows.h>\n#include <psapi.h>\n\nint main() {\n    HANDLE hProcess = GetCurrentProcess();\n    PROCESS_MEMORY_COUNTERS pmc;\n    GetProcessMemoryInfo(hProcess, &pmc, sizeof(pmc));\n    printf("Working Set Size: %d bytes\n", pmc.WorkingSetSize);\n    return 0;\n}