HANDLE ProcessHandle = GetCurrentProcess();\nDWORD ProcessAffinityMask;\nDWORD SystemAffinityMask;\nif (GetProcessAffinityMask(ProcessHandle, &ProcessAffinityMask, &SystemAffinityMask) \n    && SystemAffinityMask != 0) \n{\n    // Limit to 1 thread by masking all but 1 bit of the system affinity mask\n    DWORD NewProcessAffinityMask = ((SystemAffinityMask-1) ^ SystemAffinityMask) & SystemAffinityMask;\n    SetProcessAffinityMask(ProcessHandle, NewProcessAffinityMask);\n}