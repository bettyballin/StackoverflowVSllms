#include <windows.h>
#include <stdio.h>

int main() {
    HINSTANCE hinstLib;
    hinstLib = LoadLibrary(TEXT("comctl32"));
    if (hinstLib != NULL) {
       // Your processing...
    } else {
        fprintf(stderr, "Cannot load library");
        return -1;
    }
    return 0;
}