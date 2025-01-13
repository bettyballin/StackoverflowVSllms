#include <windows.h>\n#include <stdio.h>\n\nFILE* win32_popen(const char* command, const char* mode)\n{\n    SECURITY_ATTRIBUTES sa;\n    HANDLE hRead, hWrite;\n    STARTUPINFO si;\n    PROCESS_INFORMATION pi;\n    FILE* fp;\n\n    // Set up the security attributes struct to allow the handles to be inherited\n    sa.nLength = sizeof(SECURITY_ATTRIBUTES);\n    sa.lpSecurityDescriptor = NULL;\n    sa.bInheritHandle = TRUE;\n\n    // Create the pipe\n    if (!CreatePipe(&hRead, &hWrite, &sa, 0)) {\n        return NULL;\n    }\n\n    // Ensure the read handle to the pipe is not inherited\n    if (!SetHandleInformation(hRead, HANDLE_FLAG_INHERIT, 0)) {\n        CloseHandle(hRead);\n        CloseHandle(hWrite);\n        return NULL;\n    }\n\n    // Set up the start up info struct\n    ZeroMemory(&si, sizeof(STARTUPINFO));\n    si.cb = sizeof(STARTUPINFO);\n    si.dwFlags = STARTF_USESTDHANDLES;\n    si.hStdInput = NULL;\n    si.hStdOutput = (mode[0] == 'r') ? hWrite : hRead;\n    si.hStdError = GetStdHandle(STD_ERROR_HANDLE);\n\n    // Create the process\n    if (!CreateProcess(NULL, (LPSTR)command, NULL, NULL, TRUE, 0, NULL, NULL, &si, &pi)) {\n        CloseHandle(hRead);\n        CloseHandle(hWrite);\n        return NULL;\n    }\n\n    // Close the unnecessary ends of the pipe\n    if (mode[0] == 'r') {\n        CloseHandle(hWrite);\n        fp = _fdopen(_open_osfhandle((intptr_t)hRead, _O_RDONLY), mode);\n    } else {\n        CloseHandle(hRead);\n        fp = _fdopen(_open_osfhandle((intptr_t)hWrite, _O_WRONLY), mode);\n    }\n\n    // Close the process handles\n    CloseHandle(pi.hProcess);\n    CloseHandle(pi.hThread);\n\n    return fp;\n}\n\nint main() {\n    FILE* fp = win32_popen("dir", "r");\n    if (fp) {\n        char buffer[128];\n        while (fgets(buffer, sizeof(buffer), fp) != NULL) {\n            printf("%s", buffer);\n        }\n        fclose(fp);\n    }\n    return 0;\n}