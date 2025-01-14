#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>

int main() {
    int fds[2];      // Two file descriptors for the pipe ends
    int res = pipe(fds);  // Create the pipe, returns 0 on success

    if (res < 0) {
        perror("pipe");
        return EXIT_FAILURE;
    }

    // Now you can use fds[0] to read data from the pipe, and
    // write data into the pipe using fds[1]. Don't forget
    // to close the FDs in child processes after duplicating them.

    close(fds[0]);
    close(fds[1]);

    return EXIT_SUCCESS;
}