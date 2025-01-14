#include <windows.h>

int main() {
    HGLOBAL gGlobal = GlobalAlloc(GMEM_MOVEABLE, 0);
    return 0;
}