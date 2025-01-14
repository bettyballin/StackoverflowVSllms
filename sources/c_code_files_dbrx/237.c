#include <stdio.h>
#include <stdlib.h>

int main() {
    // Create manifest file with mt.exe
    system("mt -manifest filename.dll.manifest -out:filename.DLL.Manifest.resources");
    return 0;
}