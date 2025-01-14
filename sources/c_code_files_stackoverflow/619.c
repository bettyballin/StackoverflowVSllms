#include <windows.h>

#pragma data_seg(".shared")
HHOOK hhk = NULL;
#pragma data_seg()
#pragma comment(linker, "/SECTION:.shared,RWS")

int main() {
    // Your code here...
    return 0;
}