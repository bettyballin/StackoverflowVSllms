#include <Windows.h>\n\nDWORD GetSystemIdleTime()\n{\n    LASTINPUTINFO lastInputInfo;\n    lastInputInfo.cbSize = sizeof(lastInputInfo);\n    GetLastInputInfo(&lastInputInfo);\n\n    DWORD tickCount = GetTickCount();\n    return tickCount - lastInputInfo.dwTime;\n}\n\nint main()\n{\n    DWORD idleTime = GetSystemIdleTime();\n    printf("System idle time: %u milliseconds\n", idleTime);\n    return 0;\n}