#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    const char *src = "Hello, World!";
    char *dst = strdup(src);
    
    if (dst == NULL) {
        printf("Memory allocation failed\n");
        return EXIT_FAILURE;
    }
    
    printf("Copied string: %s\n", dst);
    free(dst); // Don't forget to free the allocated memory
    
    return EXIT_SUCCESS;
}