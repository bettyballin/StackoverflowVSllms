#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

int main() {
    int fd;
    fd = open("example.txt", O_RDONLY);

    if (fd == -1) {
        printf("Could not open file (error %d)\n", errno);
        return 1;
    }

    // Use fd with other API functions, e.g., read, write, etc.

    close(fd);
    return 0;
}