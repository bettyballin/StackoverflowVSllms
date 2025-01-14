#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

int main() {
    int filedes = open("example.txt", O_RDONLY);
    if (filedes == -1) {
        perror("open");
        exit(EXIT_FAILURE);
    }

    char buffer[1024];
    ssize_t bytes_read = pread(filedes, buffer, 1024, 0);
    if (bytes_read == -1) {
        perror("pread");
        exit(EXIT_FAILURE);
    }

    printf("Read %zd bytes: %s\n", bytes_read, buffer);

    close(filedes);
    return 0;
}