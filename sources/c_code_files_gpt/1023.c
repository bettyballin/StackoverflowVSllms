#define _GNU_SOURCE
#include <sys/types.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <poll.h> // Include poll.h for poll() function

int main() {
    pid_t pid = 1234; // Replace 1234 with the actual PID of the non-child process

    // Obtain a file descriptor for the target process
    int pidfd = pidfd_open(pid, 0);
    if (pidfd == -1) {
        perror("pidfd_open");
        exit(EXIT_FAILURE);
    }

    // Wait for the target process to exit
    struct pollfd pfd = {
        .fd = pidfd,
        .events = POLLIN,
    };

    int ret = poll(&pfd, 1, -1);
    if (ret == -1) {
        perror("poll");
        close(pidfd);
        exit(EXIT_FAILURE);
    }

    // Process has exited
    printf("Process %d has exited\n", pid); // Add newline character
    close(pidfd);
    return 0;
}