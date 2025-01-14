// a.c
#include <stdlib.h>

__declspec(dllexport) void* createBla() {
    return malloc(100);
}

// b.c
#include <stdlib.h>

extern __declspec(dllimport) void* createBla();

void consumeBla() {
    void* p = createBla();
    free(p);
}