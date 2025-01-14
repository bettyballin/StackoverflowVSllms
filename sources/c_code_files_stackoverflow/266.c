#include <windows.h>
#include <stdio.h>

int main() {
    DWORD ticks = GetTickCount();
    printf("Ticks since system startup: %u\n", ticks);
    return 0;
}