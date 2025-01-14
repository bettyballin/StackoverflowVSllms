#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

int main(int argc, char **argv) {
    if (argc != 2) {
        return 1;
    }

    int fd = open(argv[1], O_WRONLY | O_APPEND);
    while (fd == -1) {
        usleep(100000); // sleep for 100 milliseconds
        fd = open(argv[1], O_WRONLY | O_APPEND);
    }
    close(fd);

    // file should now be unlocked..
    return 0;
}