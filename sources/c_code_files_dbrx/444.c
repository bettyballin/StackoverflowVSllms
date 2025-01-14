#include <stdio.h>

// Define the macro
#define MAKE_NS_ERROR(code) ((HRESULT)(0xC00D << 16 | (code)))

// Define HRESULT if it's not already defined (it's typically defined in Windows.h)
typedef long HRESULT;

int main() {
    // Example usage of the macro
    HRESULT error = MAKE_NS_ERROR(1);
    printf("Error code: 0x%08x\n", error);
    return 0;
}