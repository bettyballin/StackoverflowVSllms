#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdint.h>

int main() {
    int fildes = open("example.txt", O_RDONLY);
    if (fildes == -1) {
        perror("Error opening file");
        return 1;
    }

    char buf[10];
    ssize_t bytes_read = pread(fildes, buf, 10, 0);
    if (bytes_read == -1) {
        perror("Error reading file");
        return 1;
    }

    buf[bytes_read] = '\0';
    printf("Read from file: %s\n", buf);

    close(fildes);
    return 0;
}