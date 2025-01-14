#include <stdint.h>

// Define types
typedef uint8_t  BYTE;
typedef uint32_t DWORD;
typedef uint8_t* PBYTE;
typedef uint32_t* PDWORD;

// Define the IMAGE_IMPORT_BY_NAME struct
typedef struct _IMAGE_IMPORT_BY_NAME {
    uint16_t Hint;
    char Name[1];
} IMAGE_IMPORT_BY_NAME, *PIMAGE_IMPORT_BY_NAME;

// Define the IMAGE_THUNK_DATA struct
typedef struct _IMAGE_THUNK_DATA {
    union {
        PBYTE  ForwarderString;
        PDWORD Function;
        DWORD  Ordinal;
        PIMAGE_IMPORT_BY_NAME AddressOfData;
    } u1;
} IMAGE_THUNK_DATA;