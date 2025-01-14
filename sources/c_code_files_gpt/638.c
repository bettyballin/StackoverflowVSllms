#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/select.h> // Added for select() function
#include <string.h> // Added for memset

#define PIPE_IN "/tmp/pipe_in"
#define PIPE_OUT "/tmp/pipe_out"

int main() {
    // Create the named pipes
    if (mkfifo(PIPE_IN, 0666) == -1) {
        perror("mkfifo");
        exit(EXIT_FAILURE);
    }

    if (mkfifo(PIPE_OUT, 0666) == -1) {
        perror("mkfifo");
        exit(EXIT_FAILURE);
    }

    // Open the input pipe in non-blocking mode
    int in_fd = open(PIPE_IN, O_RDONLY | O_NONBLOCK);
    if (in_fd == -1) {
        perror("open for reading");
        exit(EXIT_FAILURE);
    }

    // Open the output pipe in non-blocking mode
    int out_fd = open(PIPE_OUT, O_WRONLY | O_NONBLOCK);
    if (out_fd == -1) {
        perror("open for writing");
        // Close the input pipe before exiting
        close(in_fd);
        exit(EXIT_FAILURE);
    }

    // Now you can use select() or poll() on in_fd and out_fd
    // Example: Using select()
    fd_set read_fds;
    FD_ZERO(&read_fds);
    FD_SET(in_fd, &read_fds);

    struct timeval timeout;
    timeout.tv_sec = 5;  // 5 seconds timeout
    timeout.tv_usec = 0;

    int ret = select(in_fd + 1, &read_fds, NULL, NULL, &timeout);
    if (ret == -1) {
        perror("select");
    } else if (ret == 0) {
        printf("Timeout occurred! No data within 5 seconds.\n");
    } else {
        if (FD_ISSET(in_fd, &read_fds)) {
            char buffer[128];
            memset(buffer, 0, sizeof(buffer)); // Initialize buffer
            ssize_t bytesRead = read(in_fd, buffer, sizeof(buffer) - 1); // Leave space for \0
            if (bytesRead > 0) {
                buffer[bytesRead] = '\0';
                printf("Read: %s\n", buffer);
            } else if (bytesRead == 0) {
                printf("End of file.\n");
            } else {
                perror("read");
            }
        }
    }

    // Close the file descriptors
    close(in_fd);
    close(out_fd);

    // Remove the named pipes
    unlink(PIPE_IN);
    unlink(PIPE_OUT);

    return 0;
}