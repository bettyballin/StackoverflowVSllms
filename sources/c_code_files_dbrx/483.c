#include <windows.h>
#include <stdlib.h>
#include <stdio.h> // Added for puts function

typedef char* (__stdcall *GETCPUID)(unsigned char); // Declare function pointer for GetCPUID
typedef char* (__stdcall *GETPID)(char*);           // Declare function pointer for GetPartitionID

int main() {
    HMODULE hWtsLib = LoadLibraryA("HardwareIDExtractor.dll"); // Changed to LoadLibraryA for ASCII string
    if (hWtsLib){
        GETCPUID pGetSerial;
        GETPID pGetPID;

        char* str = (char*)malloc(1024);
        pGetSerial = (GETCPUID)GetProcAddress(hWtsLib, "GetCPUID"); // Load GetCPUID function address
        *str = pGetSerial((BYTE)"1"[0]);                            // Use the function pointer to call the function from DLL, passing a single byte value to it ('1'[0])

        char* str1 = (char*)malloc(1024);
        pGetPID = (GETPID)GetProcAddress(hWtsLib, "GetPartitionID"); // Load GetPartitionID function address
        *str1 = pGetPID("C:");                                      // Use the function pointer to call the function from DLL
    } else {
        puts("Error loading library.");
    }
    return 0; // Added return statement
}