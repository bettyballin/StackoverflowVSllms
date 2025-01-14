#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>

void deleteFileOnClose(const char *filePath) {
    int fd = open(filePath, O_RDWR);
    if (fd != -1) {
        // Unlink the file so it will be deleted when the last reference is closed
        if (unlink(filePath) == 0) {
            // Now the file will be deleted after the last file descriptor is closed
            printf("File will be deleted after the last file descriptor is closed\n");
        } else {
            perror("unlink");
        }
        close(fd);
    } else {
        perror("open");
    }
}

int main() {
    deleteFileOnClose("test.txt");
    return 0;
}