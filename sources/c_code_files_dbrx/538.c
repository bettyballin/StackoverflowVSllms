#include <windows.h>
#include <stdio.h>

int main() {
    HANDLE job = CreateJobObject(NULL, NULL);
    if (job == NULL) {
        printf("CreateJobObject failed with %d\n", GetLastError());
        return 1;
    }

    DWORD pid; // assume this is initialized with a valid process ID
    HANDLE h = OpenProcess(PROCESS_SET_QUOTA | SYNCHRONIZE, FALSE, pid);
    if (h == NULL) {
        printf("OpenProcess failed with %d\n", GetLastError());
        CloseHandle(job);
        return 1;
    }

    if (FALSE == AssignProcessToJobObject(job, h)) {
        printf("AssignProcessToJobObject failed with %d\n", GetLastError());
    }

    CloseHandle(h);
    CloseHandle(job);
    return 0;
}