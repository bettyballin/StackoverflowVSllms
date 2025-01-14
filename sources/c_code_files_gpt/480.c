#include <stdio.h>

void driverUnload() {
    printf("Driver Unloading\n");
}

int main() {
    printf("Driver Loaded\n");
    atexit(driverUnload);
    return 0;
}