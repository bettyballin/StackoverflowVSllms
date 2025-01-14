#include <stdio.h>
#include <stdint.h>

// Define types if not using Windows API
typedef uint32_t DWORD;
typedef uint16_t WORD;
typedef uint8_t BYTE;

typedef struct _GUID 
{  
   DWORD Data1;  
   WORD Data2;  
   WORD Data3;  
   WORD Data4;  
   BYTE Data5[6]; 
} GUID;

int main() {
    GUID myGuid;
    myGuid.Data1 = 0x12345678;
    myGuid.Data2 = 0x1234;
    myGuid.Data3 = 0x5678;
    myGuid.Data4 = 0x9012;
    for (int i = 0; i < 6; ++i) {
        myGuid.Data5[i] = (BYTE)i;
    }

    printf("GUID: %08x-%04x-%04x-%04x-", myGuid.Data1, myGuid.Data2, myGuid.Data3, myGuid.Data4);
    for (int i = 0; i < 6; ++i) {
        printf("%02x", myGuid.Data5[i]);
    }
    printf("\n");

    return 0;
}