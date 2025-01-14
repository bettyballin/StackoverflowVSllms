#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    const char *original = "Hello, World!";
    char *duplicate = strdup(original);

    if (duplicate == NULL) {
        perror("strdup");
        exit(EXIT_FAILURE);
    }

    printf("Original: %s\n", original);
    printf("Duplicate: %s\n", duplicate);

    // Free the memory allocated by strdup()
    free(duplicate);

    return 0;
}