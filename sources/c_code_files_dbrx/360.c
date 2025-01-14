#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Define GLboolean type
typedef unsigned char GLboolean;

// Define DLLEXPORT macro for GCC
#ifndef DLLEXPORT
#define DLLEXPORT __attribute__((visibility("default")))
#endif

DLLEXPORT GLboolean load_obj(const char* filename, unsigned int* object_list) {
    // Function implementation goes here...
    // For demonstration purposes, let's just print the filename and return True
    printf("Loading object from file: %s\n", filename);
    return GL_TRUE; // Assuming GL_TRUE is defined as 1
}

int main() {
    unsigned int object_list[10];
    load_obj("example.obj", object_list);
    return 0;
}