HANDLE ProcessHandle = GetCurrentProcess();\nSetPriorityClass(ProcessHandle, BELOW_NORMAL_PRIORITY_CLASS);