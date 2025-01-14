#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

int main() {
    // Open the file in read-write mode
    int fd = open("myfilepath", O_RDWR);
    if (fd != -1) {
        // Seek to the end of the initial data block
        if (lseek(fd, nInitialDataSize, SEEK_SET) != -1) {
            // Truncate the file to the current position
            if (ftruncate(fd, lseek(fd, 0, SEEK_CUR)) != -1) {
                printf("The old end was successfully cleared.\n");
            } else {
                printf("Failed to clear the file: %s\n", strerror(errno));
            }
        } else {
            printf("Failed to seek to the end of the initial data block: %s\n", strerror(errno));
        }
    } else {
        printf("Failed to open the file: %s\n", strerror(errno));
    }

    // Close the file descriptor
    close(fd);

    return 0;
}