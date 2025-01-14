#include <stdio.h>
#include <string.h>

// Define a struct to hold the directory
typedef struct {
    char Directory[256];
} DLB_t;

// Function to write the last directory
void WriteLastDirectory(const char *directory) {
    printf("Last directory: %s\n", directory);
}

int main() {
    // Create an instance of the DLB_t struct
    DLB_t DLB;
    strcpy(DLB.Directory, "/path/to/directory");

    // Call the WriteLastDirectory function
    WriteLastDirectory(DLB.Directory);

    return 0;
}