#include <stdlib.h>

char* createString() {
    char* str = malloc(100 * sizeof(char));
    // Initialize str
    return str;
}

int main() {
    char* str = createString();
    // Use the created string
    free(str);  // Don't forget to free the allocated memory
    return 0;
}