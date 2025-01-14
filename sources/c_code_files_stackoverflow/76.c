#include <stdio.h>

// Function declaration for tmpfile
FILE * tmpfile ( void );

int main() {
    // Create a temporary file
    FILE *tmp = tmpfile();

    // Check if the temporary file was created successfully
    if (tmp == NULL) {
        perror("tmpfile");
        return 1;
    }

    // Example usage: write something to the temporary file
    fprintf(tmp, "Hello, world!\n");

    // Close the temporary file
    fclose(tmp);

    return 0;
}