#include <windows.h>
#include <stdio.h>

int main() {
    // Define variables
    SECURITY_ATTRIBUTES saAttr;
    HANDLE hChildStdOutRd, hChildStdOutWr;
    PROCESS_INFORMATION piProcInfo;
    STARTUPINFO siStartInfo;
    DWORD dwRead;
    CHAR chBuf[4096];
    BOOL bSuccess = FALSE;

    // Set the security attributes structure
    saAttr.nLength = sizeof(SECURITY_ATTRIBUTES);
    saAttr.bInheritHandle = TRUE;
    saAttr.lpSecurityDescriptor = NULL;

    // Create a pipe for the child process's STDOUT
    if (!CreatePipe(&hChildStdOutRd, &hChildStdOutWr, &saAttr, 0)) {
        fprintf(stderr, "Stdout pipe creation failed\n");
        return 1;
    }

    // Ensure the read handle to the pipe for STDOUT is not inherited
    if (!SetHandleInformation(hChildStdOutRd, HANDLE_FLAG_INHERIT, 0)) {
        fprintf(stderr, "Stdout SetHandleInformation failed\n");
        return 1;
    }

    // Set up members of the STARTUPINFO structure
    ZeroMemory(&siStartInfo, sizeof(STARTUPINFO));
    siStartInfo.cb = sizeof(STARTUPINFO);
    siStartInfo.hStdError = hChildStdOutWr;
    siStartInfo.hStdOutput = hChildStdOutWr;
    siStartInfo.dwFlags |= STARTF_USESTDHANDLES;

    // Create the child process
    bSuccess = CreateProcess(NULL,
        "child_program.exe",      // Command line
        NULL,                    // Process security attributes
        NULL,                    // Primary thread security attributes
        TRUE,                    // Handles are inherited
        0,                       // Creation flags
        NULL,                    // Use parent's environment
        NULL,                    // Use parent's current directory
        &siStartInfo,            // STARTUPINFO pointer
        &piProcInfo);            // Receives PROCESS_INFORMATION

    // If an error occurs, exit the application
    if (!bSuccess) {
        fprintf(stderr, "CreateProcess failed\n");
        return 1;
    } else {
        // Close the write end of the pipe before reading from the read end of the pipe
        CloseHandle(hChildStdOutWr);

        // Read output from the child process
        for (;;) {
            bSuccess = ReadFile(hChildStdOutRd, chBuf, sizeof(chBuf), &dwRead, NULL);
            if (!bSuccess || dwRead == 0) break;

            // Write to parent process's STDOUT
            fwrite(chBuf, 1, dwRead, stdout);
        }

        // Wait until child process exits
        WaitForSingleObject(piProcInfo.hProcess, INFINITE);

        // Close handles
        CloseHandle(piProcInfo.hProcess);
        CloseHandle(piProcInfo.hThread);
        CloseHandle(hChildStdOutRd);
    }

    return 0;
}