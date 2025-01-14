#include <stdio.h>
#include <stdlib.h> // For malloc
#include <string.h> // For strcpy
// #include "LabviewDLLExample.h" // Commented out as not necessary for this snippet

char* getString(void) {
    const char str[] = "Hello from C!";
    int len = sizeof(str);
    char *result = (char*)malloc((len)*sizeof(char)); // Corrected allocation size; no need to add 1 for null terminator as sizeof(str) already includes it
    strcpy(result, str);
    return result;
}

int main() {
    char* string = getString();
    printf("%s\n", string);
    free(string); // To prevent memory leak, free the allocated memory
    return 0;
}