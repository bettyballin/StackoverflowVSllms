#include <stdint.h>

// Define the types
typedef uint32_t DWORD;
typedef uint16_t WORD;
typedef uint8_t BYTE;

// Define the GUID struct
typedef struct _GUID 
{  
   DWORD Data1;  
   WORD Data2;  
   WORD Data3;  
   BYTE Data4[8];
} GUID;