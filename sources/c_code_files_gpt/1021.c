#include <windows.h>
#include <stdio.h>
#include <io.h>
#include <fcntl.h>

FILE* win32_popen(const char* command, const char* mode)
{
    SECURITY_ATTRIBUTES sa;
    HANDLE hRead, hWrite;
    STARTUPINFO si;
    PROCESS_INFORMATION pi;
    FILE* fp;

    // Set up the security attributes struct to allow the handles to be inherited
    sa.nLength = sizeof(SECURITY_ATTRIBUTES);
    sa.lpSecurityDescriptor = NULL;
    sa.bInheritHandle = TRUE;

    // Create the pipe
    if (!CreatePipe(&hRead, &hWrite, &sa, 0)) {
        return NULL;
    }

    // Ensure the read handle to the pipe is not inherited
    if (!SetHandleInformation(hRead, HANDLE_FLAG_INHERIT, 0)) {
        CloseHandle(hRead);
        CloseHandle(hWrite);
        return NULL;
    }

    // Set up the start up info struct
    ZeroMemory(&si, sizeof(STARTUPINFO));
    si.cb = sizeof(STARTUPINFO);
    si.dwFlags = STARTF_USESTDHANDLES;
    si.hStdInput = NULL;
    si.hStdOutput = (mode[0] == 'r') ? hWrite : hRead;
    si.hStdError = GetStdHandle(STD_ERROR_HANDLE);

    // Create the process
    if (!CreateProcess(NULL, (LPSTR)command, NULL, NULL, TRUE, 0, NULL, NULL, &si, &pi)) {
        CloseHandle(hRead);
        CloseHandle(hWrite);
        return NULL;
    }

    // Close the unnecessary ends of the pipe
    if (mode[0] == 'r') {
        CloseHandle(hWrite);
        fp = _fdopen(_open_osfhandle((intptr_t)hRead, _O_RDONLY), mode);
    } else {
        CloseHandle(hRead);
        fp = _fdopen(_open_osfhandle((intptr_t)hWrite, _O_WRONLY), mode);
    }

    // Close the process handles
    CloseHandle(pi.hProcess);
    CloseHandle(pi.hThread);

    return fp;
}

int main() {
    FILE* fp = win32_popen("dir", "r");
    if (fp) {
        char buffer[128];
        while (fgets(buffer, sizeof(buffer), fp) != NULL) {
            printf("%s", buffer);
        }
        fclose(fp);
    }
    return 0;
}