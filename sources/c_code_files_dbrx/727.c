#include <Windows.h>
#include <Psapi.h>

int main() {
    HANDLE hProcess;
    FILETIME ftc, ftu, foo;
    FILETIME fi; // Not used in the original code, but declared to avoid compiler error
    PROCESS_INFORMATION pi;
    STARTUPINFO si;

    // Initialize the structures
    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));

    // Create a new process
    CreateProcess(NULL, NULL, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi);

    // Get the process times
    GetProcessTimes(pi.hProcess, &ftc, &fi, &ftu, &foo);

    // Get the process memory info
    PROCESS_MEMORY_COUNTERS pmc;
    pmc.cb = sizeof(pmc);
    GetProcessMemoryInfo(pi.hProcess, &pmc, sizeof(pmc));

    // Do something with the memory info
    printf("Working set size: %d\n", pmc.WorkingSetSize);

    // Close the process handle
    CloseHandle(pi.hProcess);
    CloseHandle(pi.hThread);

    return 0;
}