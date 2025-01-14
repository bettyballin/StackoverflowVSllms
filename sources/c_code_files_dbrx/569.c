#include <stdio.h>
#include <stdlib.h>

int main() {
    // Open the file
    FILE *f = fopen("yourfile", "r");
    if (f == NULL) {
        fprintf(stderr, "Failed to open file.\n");
        return EXIT_FAILURE;
    }

    char str[1024];
    while (fgets(str, sizeof str, f)) {
        // Do something with str...
        printf("%s", str); // Example: Print the string
    }

    // Close the file
    fclose(f);

    return EXIT_SUCCESS;
}