#include <unistd.h>     // For ftruncate
#include <fcntl.h>      // For open, O_RDWR
#include <stdlib.h>     // For EXIT_FAILURE, EXIT_SUCCESS
#include <stdio.h>      // For perror

int main() {
    const char *filename = "example.txt";
    int newSize = 100;  // New size in bytes

    // Open the file
    int fd = open(filename, O_RDWR);
    if (fd == -1) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    // Truncate the file
    if (ftruncate(fd, newSize) == -1) {
        perror("Error truncating file");
        close(fd);
        return EXIT_FAILURE;
    }

    // Close the file
    close(fd);

    printf("File truncated successfully.\n");
    return EXIT_SUCCESS;
}