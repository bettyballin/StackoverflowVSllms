#include <stdio.h>  // For printf
#include <stdlib.h> // For malloc
#include <string.h> // For strlen and strcpy

char *my_strdup(const char *src) {
    char *dst = malloc(strlen(src) + 1);  // Space for length plus nul
    if (dst == NULL) return NULL;          // No memory
    strcpy(dst, src);                      // Copy the characters
    return dst;                            // Return the new string
}

int main() {
    const char *original = "Hello, World!";
    char *copied = my_strdup(original);
    if (copied != NULL) {
        printf("Copied string: %s\n", copied);
        free(copied); // Don't forget to free the allocated memory
    } else {
        printf("Memory allocation failed\n");
    }
    return 0;
}