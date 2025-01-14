#include <stdio.h>
#include <unistd.h>
#include <limits.h>
#include <stdlib.h> // Added for atoi function

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <file_descriptor>\n", argv[0]); // Fixed newline character
        return 1;
    }

    int fd = atoi(argv[1]);
    char path[PATH_MAX];
    char actualpath[PATH_MAX];

    snprintf(path, sizeof(path), "/proc/self/fd/%d", fd);
    ssize_t len = readlink(path, actualpath, sizeof(actualpath) - 1);
    
    if (len == -1) {
        perror("readlink");
        return 1;
    }
    
    actualpath[len] = '\0';
    printf("Filename for file descriptor %d is: %s\n", fd, actualpath); // Fixed newline character

    return 0;
}