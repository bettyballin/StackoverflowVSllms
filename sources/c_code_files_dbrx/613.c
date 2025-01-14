#include <windows.h>

int value1 = 0;
int value2 = 0;
int oldValue = 0;
int newValue = 0;

int main() {
    CRITICAL_SECTION cs;
    InitializeCriticalSection(&cs);
    EnterCriticalSection(&cs);
    value1++;
    value2++;
    oldValue = newValue;
    LeaveCriticalSection(&cs);
    return 0;
}