#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    const char *filename = "example.txt";
    int fd;

    // Open the file
    fd = open(filename, O_WRONLY);
    if (fd == -1) {
        perror("open");
        return 1;
    }

    // Truncate the file to the desired length (e.g., 100 bytes)
    if (ftruncate(fd, 100) == -1) {
        perror("ftruncate");
        close(fd);
        return 1;
    }

    // Close the file
    close(fd);
    return 0;
}