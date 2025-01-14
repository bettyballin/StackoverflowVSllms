#include <stdio.h>
#include <stdlib.h>

// Define dump_f as a FILE pointer
FILE *dump_f;

void someFunction() {
    // Assign stdout to fp[0]
    fp[0] = stdout;
    
    // Assign dump_f to fp[1]
    fp[1] = dump_f;
}

int main() {
    // Open the file "dump.txt" for writing and assign it to dump_f
    dump_f = fopen("dump.txt", "w");
    if (dump_f == NULL) {
        fprintf(stderr, "Could not open dump.txt for writing.\n");
        exit(EXIT_FAILURE);
    }
    
    // Declare fp array
    FILE *fp[2];
    
    // Call someFunction
    someFunction();
    
    // Example usage: write to stdout and the file
    fprintf(fp[0], "This is sent to stdout.\n");
    fprintf(fp[1], "This is sent to dump.txt.\n");
    
    // Close the file
    fclose(dump_f);
    
    return 0;
}