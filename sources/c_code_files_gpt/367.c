#include <stdio.h>
#include <stdlib.h>

int main() {
    // Retrieve the HOMEPATH environment variable
    char *homepath = getenv("HOMEPATH");
    if (homepath == NULL) {
        fprintf(stderr, "Error: HOMEPATH environment variable not found.\n");
        return 1;
    }

    // Construct the full path to the desktop
    char filepath[1024];
    snprintf(filepath, sizeof(filepath), "C:\\%s\\Desktop\\helloworld.txt", homepath);

    // Open the file for writing
    FILE *fd = fopen(filepath, "w");
    if (fd == NULL) {
        perror("Error opening file");
        return 1;
    }

    // Write to the file
    fprintf(fd, "Hello, world!\n");

    // Close the file
    fclose(fd);

    return 0;
}