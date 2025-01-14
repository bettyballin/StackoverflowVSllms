#include <stdio.h>

__attribute__((visibility("default")))
void myExportedFunction() {
    printf("Hello from exported function!\n");
}