#include <windows.h>\n\ntypedef struct _IMAGE_IMPORT_DESCRIPTOR {\n    union {\n        DWORD   Characteristics;         // 0 for terminating null Import Descriptor\n        DWORD   OriginalFirstThunk;      // RVA to original unbound IAT (PIMAGE_THUNK_DATA)\n    };\n    DWORD   TimeDateStamp;             // 0 if not bound, -1 if bound, date/time stamp otherwise\n    DWORD   ForwarderChain;            // -1 if no forwarders\n    DWORD   NameRVA;                   // RVA to dll name\n    DWORD   FirstThunk;                // RVA to IAT (if bound this IAT has actual addresses)\n} IMAGE_IMPORT_DESCRIPTOR, *PIMAGE_IMPORT_DESCRIPTOR;\n\ntypedef struct _IMAGE_THUNK_DATA32 {\n    union {\n        DWORD ForwarderString;      // PBYTE\n        DWORD Function;             // PDWORD\n        DWORD Ordinal;\n        DWORD AddressOfData;         // PIMAGE_IMPORT_BY_NAME\n    } u1;\n} IMAGE_THUNK_DATA32, *PIMAGE_THUNK_DATA32;\n\ntypedef struct _IMAGE_IMPORT_BY_NAME {\n    WORD Hint;                      // Hint for DllName\n    BYTE Name[1];                   // DllName with 0-byte appended to it\n} IMAGE_IMPORT_BY_NAME, *PIMAGE_IMPORT_BY_NAME;