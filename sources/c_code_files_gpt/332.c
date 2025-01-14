#include <windows.h>
#include <stdio.h>
#include <string.h>

// Define the function pointers
typedef char* (__stdcall *GETCPUID)(BYTE);
typedef char* (__stdcall *GETPID)(const char*);

// Helper function to convert ShortString to C string
void ConvertShortString(const char* src, char* dest) {
    if (src && dest) {
        int length = (unsigned char)src[0]; // First byte is length of the string
        memcpy(dest, &src[1], length);
        dest[length] = '\0';
    }
}

int main() {
    // Load the DLL
    HMODULE hWtsLib = LoadLibrary("HardwareIDExtractor.dll");
    if (hWtsLib) {
        // Get the function addresses
        GETCPUID pGetSerial = (GETCPUID)GetProcAddress(hWtsLib, "GetCPUID");
        GETPID pGetPID = (GETPID)GetProcAddress(hWtsLib, "GetPartitionID");
        
        if (pGetSerial && pGetPID) {
            // Allocate memory for the ShortString result
            char shortStringResult[256]; // Maximum size of ShortString is 256 bytes

            // Call GetCPUID function
            char result[256]; // Buffer for converted C string
            char* shortString = pGetSerial(1);
            ConvertShortString(shortString, result);
            printf("CPUID: %s\n", result);

            // Call GetPartitionID function
            shortString = pGetPID("C:");
            ConvertShortString(shortString, result);
            printf("PartitionID: %s\n", result);
        } else {
            printf("Failed to get function addresses.\n");
        }

        // Free the DLL
        FreeLibrary(hWtsLib);
    } else {
        printf("Failed to load the DLL.\n");
    }

    return 0;
}