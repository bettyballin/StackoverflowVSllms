HANDLE hProcess = ShellExecute(NULL, "open", "your_process.exe", NULL, NULL, SW_SHOWDEFAULT);\nif (hProcess > 32) {\n    WaitForSingleObject(hProcess, INFINITE);\n    DWORD exitCode;\n    if (GetExitCodeProcess(hProcess, &exitCode)) {\n        // exitCode now holds the return value of the process\n    }\n}