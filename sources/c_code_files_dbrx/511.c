#include <sys/ioctl.h>
#include <stdio.h>

#define IO_COMMAND _IO('R', 0) // Replace 'R' and 0 with your actual command type and number

int main() {
    int fd; // Assuming fd is a valid file descriptor
    int ret = ioctl(fd, IO_COMMAND);
    if (-1 == ret) {
        // Error handling code here
        perror("ioctl");
    }
    return 0;
}