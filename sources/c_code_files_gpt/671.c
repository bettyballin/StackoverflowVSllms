#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Define the Stringpool_char structure for demonstration purposes
typedef struct {
    char data[10];  // Assuming a size of 10 for demonstration
} Stringpool_char;

int main() {
    int len = 20;  // Example length
    Stringpool_char *ret = malloc(len * sizeof(Stringpool_char));
    if (ret == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    // Your original line of code
    memset(ret + len - 1, 0, sizeof(Stringpool_char));

    // Free the allocated memory
    free(ret);

    return 0;
}