#include <stdio.h>
#include <windows.h>

void TerminateTree(DWORD PID) {
    HANDLE hSnapshot;
    PROCESSENTRY32 pe32;

    // Take snapshot of all process
    hSnapshot = CreateToolhelp32Snapshot(TH32CS_SNAPPROCESS, 0);
    if (hSnapshot == INVALID_HANDLE_VALUE) {
        fprintf(stderr, "CreateToolhelp32Snapshot failed: %d\n", GetLastError());
        return;
    }

    // Set size to pe32 structure before using it.
    pe32.dwSize = sizeof(PROCESSENTRY32);

    if (!Process32First(hSnapshot, &pe32)) {
        fprintf(stderr, "No processes found.\n");
        CloseHandle(hSnapshot); // Close handle before returning
        return;
    }

    do {
       // Check if it's the current Process ID (PID) or any child process of the PID
       if ((pe32.th32ParentProcessID == PID) || (pe32.th32ProcessID == PID)) {
           HANDLE hProc = OpenProcess(PROCESS_TERMINATE, FALSE, pe32.th32ProcessID);
           if (hProc == NULL) {
               fprintf(stderr, "Could not open process '%s' with PID: %d\n",
                       pe32.szExeFile, (int) pe32.th32ProcessID);
           } else {
               if (!TerminateProcess(hProc, 0)) {
                   fprintf(stderr, "Could not terminate process '%s' with PID: %d\n",
                           pe32.szExeFile, (int) pe32.th32ProcessID);
               } else {
                   printf("Terminated process '%s'\tPID: %d, Parent PID (PPID): %d\n",
                          pe32.szExeFile, (int) pe32.th32ProcessID, (int) pe32.th32ParentProcessID);
               }
               CloseHandle(hProc);
           }
       }
    } while (Process32Next(hSnapshot, &pe32)); // Get next process until there is no more

    // Don't forget to close the handle when done! Otherwise you could have a memory leak.
    CloseHandle(hSnapshot);
}

int main() {
    DWORD PID;
    printf("Enter the Process ID to terminate: ");
    scanf("%u", &PID);
    TerminateTree(PID);
    return 0;
}