#include <windows.h>

int main() {
    PROCESS_INFORMATION pi;
    STARTUPINFO si = { sizeof(si) };
    if (!CreateProcess("path\\to\\yourapp.exe", NULL, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
        /* error handling */
        return 1;
    }
    return 0;
}