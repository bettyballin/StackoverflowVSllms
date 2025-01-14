#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/ioctl.h>
#include <errno.h>

// Assuming IO_COMMAND is defined elsewhere (e.g., in a header file or elsewhere in the codebase)
// For demonstration purposes, you should replace this with a valid command
#define IO_COMMAND _IO('M', 1) // Example command, replace as necessary

int main() {
    int fd = open("/dev/example", O_RDWR); // Replace "/dev/example" with the actual device file
    if (fd == -1) {
        perror("Failed to open device");
        exit(EXIT_FAILURE);
    }

    int ret = ioctl(fd, IO_COMMAND);
    if (-1 == ret) {
        perror("ioctl failed");
        close(fd);
        exit(EXIT_FAILURE);
    }

    close(fd);
    return EXIT_SUCCESS;
}