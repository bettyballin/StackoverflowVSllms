#include <stdint.h>

// Define DWORD type, which is a 32-bit unsigned integer
typedef uint32_t DWORD;

// Define the struct
typedef struct _IMAGE_IMPORT_DESCRIPTOR {
    union {
        DWORD   Characteristics;    // 0 for terminating null import descriptor
        DWORD   OriginalFirstThunk; // RVA to original unbound IAT (PIMAGE_THUNK_DATA)
    } DUMMYUNIONNAME;
    DWORD   TimeDateStamp;          // 0 if not bound,
                                    // -1 if bound, and real date\time stamp
                                    //     in IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT (new BIND)
                                    // O.W. date/time stamp of DLL bound to (Old BIND)
    DWORD   ForwarderChain;         // -1 if no forwarders
    DWORD   Name;                   // RVA to DLL name (null-terminated ASCII string)
    DWORD   FirstThunk;             // RVA to IAT (if bound this IAT has actual addresses)
} IMAGE_IMPORT_DESCRIPTOR;

int main() {
    // You can use the IMAGE_IMPORT_DESCRIPTOR struct here
    return 0;
}