#include <poll.h>
#include <stdio.h>

// Function declaration
int poll(struct pollfd fds[], nfds_t nfds, int timeout);

int main() {
    // Example usage of the poll function
    struct pollfd fds[1];
    nfds_t nfds = 1;
    int timeout = 1000; // 1 second

    fds[0].fd = 0; // stdin
    fds[0].events = POLLIN;

    int ret = poll(fds, nfds, timeout);

    if (ret > 0) {
        printf("Poll returned %d\n", ret);
    } else {
        perror("poll");
    }

    return 0;
}