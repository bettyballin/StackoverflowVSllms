#include <windows.h>
#include <stdio.h>

int main() {
    HANDLE hJob = CreateJobObject(NULL, NULL);
    if (hJob == NULL) {
        fprintf(stderr, "CreateJobObject failed (%d)\n", GetLastError());
        return 1;
    }

    JOBOBJECT_EXTENDED_LIMIT_INFORMATION jeli = {0};
    jeli.BasicLimitInformation.LimitFlags = JOB_OBJECT_LIMIT_KILL_ON_JOB_CLOSE;

    if (!SetInformationJobObject(hJob, JobObjectExtendedLimitInformation, &jeli, sizeof(jeli))) {
        fprintf(stderr, "SetInformationJobObject failed (%d)\n", GetLastError());
        return 1;
    }

    STARTUPINFO si = { sizeof(si) };
    PROCESS_INFORMATION pi;

    if (!CreateProcess(NULL, "child_executable.exe", NULL, NULL, FALSE, CREATE_SUSPENDED | CREATE_BREAKAWAY_FROM_JOB, NULL, NULL, &si, &pi)) {
        fprintf(stderr, "CreateProcess failed (%d)\n", GetLastError());
        return 1;
    }

    if (!AssignProcessToJobObject(hJob, pi.hProcess)) {
        fprintf(stderr, "AssignProcessToJobObject failed (%d)\n", GetLastError());
        TerminateProcess(pi.hProcess, 1);
        return 1;
    }

    ResumeThread(pi.hThread);
    CloseHandle(pi.hThread);
    CloseHandle(pi.hProcess);

    // Parent process code
    Sleep(10000); // Simulate parent process work

    CloseHandle(hJob); // This will terminate the child processes

    return 0;
}