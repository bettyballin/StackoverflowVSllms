#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    const char *filename = "example.txt";

    // Using truncate to set file length
    if (truncate(filename, 100) != 0) {
        perror("truncate");
        return 1;
    }

    // Using ftruncate to set file length
    int fd = open(filename, O_WRONLY);
    if (fd == -1) {
        perror("open");
        return 1;
    }
    if (ftruncate(fd, 50) != 0) {
        perror("ftruncate");
        close(fd);
        return 1;
    }
    close(fd);

    return 0;
}