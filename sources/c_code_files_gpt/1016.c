#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void vulnerable_function(const char *input) {
    char *heap_buffer = (char *)malloc(64 * sizeof(char));
    if (heap_buffer == NULL) {
        perror("malloc");
        exit(EXIT_FAILURE);
    }
    // Vulnerability: no bounds checking on strcpy
    strcpy(heap_buffer, input);
    printf("Heap buffer content: %s\n", heap_buffer);
    free(heap_buffer);
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s <input>\n", argv[0]);
        return 1;
    }
    vulnerable_function(argv[1]);
    return 0;
}