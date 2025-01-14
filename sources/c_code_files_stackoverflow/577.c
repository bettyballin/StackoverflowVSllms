#include <Windows.h>

bool IsForegroundProcess(DWORD pid)
{
   HWND hwnd = GetForegroundWindow();
   if (hwnd == NULL) return false;

   DWORD foregroundPid;
   if (GetWindowThreadProcessId(hwnd, &foregroundPid) == 0) return false;

   return (foregroundPid == pid);
}

int main() {
    // Example usage:
    DWORD pid = 1234; // Replace with the desired process ID
    bool result = IsForegroundProcess(pid);
    return 0;
}