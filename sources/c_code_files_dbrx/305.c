#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    // 80000 pointers to char, each able to point to a string of various length
    // this is an array of strings
    char *string_array[80000];

    // single null-terminated string, stored contiguously in memory and having max size equal to 79999 chars plus null terminator
    // this is a character buffer or simple "string" as used in C.
    char single_string[80000];

    // Example usage:
    // Assign a string to the first element of the string array
    string_array[0] = "Hello, World!";
    printf("String from array: %s\n", string_array[0]);

    // Copy a string into the single_string buffer
    strcpy(single_string, "This is a single string.");
    printf("Single String: %s\n", single_string);

    return 0;
}