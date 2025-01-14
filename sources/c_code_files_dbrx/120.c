#include <fcntl.h>   /* For O_* constants */
#include <sys/stat.h> /* For mode constants */
#include <unistd.h>  /* for open, close */

#define PIPE_IN "path_to_your_pipe" // You need to define the path to your pipe

int main() {
    int fd_in;

    fd_in = open(PIPE_IN, O_RDONLY | O_NONBLOCK); // Open the pipe in non-blocking read mode

    // You should also check if the open was successful
    if (fd_in == -1) {
        // handle error
    }

    // Don't forget to close the file descriptor when you're done
    close(fd_in);

    return 0;
}