#include <stdio.h>    // Make sure to include the correct header for I/O functions in C
#include <stdlib.h>   // Include header for exit status macros

int main(int argc, char* argv[]) {
    FILE *fp = fopen("path_to_file.bin", "wb");   // Open file in binary write mode using fopen()
    if (fp == NULL) {                             // Check if file pointer is null after opening the file
        printf("error creating file\n");          // Added newline character at the end of the string
        return EXIT_FAILURE;                      // Use standard exit status macro
    }
    int val = 4;                                 // Variable to be written into binary file

    fwrite(&val, sizeof(int), 1, fp);          // Write variable value to file using '&' address operator
    if (ferror(fp)) {                           // Use `ferror()` to check if any error occurred during write operation
        printf("error writing file\n");          // Added newline character at the end of the string
        fclose(fp);
        return EXIT_FAILURE;                      // Use standard exit status macro
    }

    if (fclose(fp) == EOF) {                   // Check if there was an error while closing the file. The function returns EOF on failure.
        printf("error closing file\n");          // Added newline character at the end of the string
        return EXIT_FAILURE;                      // Use standard exit status macro
    }

    return EXIT_SUCCESS;                         // Use standard exit status macro
}