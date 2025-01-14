#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *getp() {
    char *s = (char *)malloc(6 * sizeof(char)); // Allocate memory on the heap
    if (s != NULL) {
        strcpy(s, "hello"); // Copy the string to the allocated memory
    } else {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE); // Exit the program if allocation fails
    }
    return s;
}

int main() {
    char *str = getp();
    printf("%s\n", str); // Note: Added newline character here
    free(str); // Don't forget to free the allocated memory
    return 0;
}