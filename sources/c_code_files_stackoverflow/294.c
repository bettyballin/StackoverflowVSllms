#include <Windows.h>
#include <stdio.h>

int main() {
    // Assuming the task is to demonstrate or use these constants
    DWORD accessMode1 = STGM_READ | STGM_SHARE_DENY_WRITE;
    DWORD accessMode2 = STGM_READWRITE | STGM_SHARE_EXCLUSIVE;
    DWORD accessMode3 = STGM_READ | STGM_PRIORITY;
    
    // Print out the values for demonstration
    printf("Access Mode 1: 0x%08X\n", accessMode1);
    printf("Access Mode 2: 0x%08X\n", accessMode2);
    printf("Access Mode 3: 0x%08X\n", accessMode3);
    
    return 0;
}