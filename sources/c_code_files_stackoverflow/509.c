#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>

int truncate(const char *path, off_t length) {
    int fd = open(path, O_WRONLY);
    if (fd == -1) {
        return -1;
    }

    if (ftruncate(fd, length) == -1) {
        close(fd);
        return -1;
    }

    close(fd);
    return 0;
}

int main() {
    const char *path = "example.txt";
    off_t length = 10;
    int ret = truncate(path, length);

    if (ret == -1) {
        perror("truncate");
    } else {
        printf("Truncated %s to %ld bytes\n", path, length);
    }

    return 0;
}