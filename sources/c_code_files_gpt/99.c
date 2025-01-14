#include <windows.h>
#include <stdio.h>

int main() {
    OSVERSIONINFO osvi;
    SYSTEM_INFO si;

    ZeroMemory(&osvi, sizeof(OSVERSIONINFO));
    osvi.dwOSVersionInfoSize = sizeof(OSVERSIONINFO);

    if (GetVersionEx(&osvi)) {
        printf("Operating System: Windows %ld.%ld\n", osvi.dwMajorVersion, osvi.dwMinorVersion);
    }

    GetSystemInfo(&si);
    printf("Processor Architecture: %d\n", si.wProcessorArchitecture);
    printf("Number of Processors: %d\n", si.dwNumberOfProcessors);

    return 0;
}