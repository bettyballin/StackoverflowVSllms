#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <errno.h>

#define PIPE_OUT "pipe_out"
#define FIFO_NAME "fifo_name"

int main() {
    int fd_out;

    if (access(PIPE_OUT, F_OK) != -1 && access(PIPE_OUT, R_OK | W_OK) == 0) {
        // The pipe exists and has at least one process with write permission.
    } else if ((fd_out = open(FIFO_NAME, O_WRONLY|O_CREAT|O_EXCL, 0622)) != -1) {
        // Create the pipe as a writer only if it doesn't exist yet.
    }

    return 0;
}