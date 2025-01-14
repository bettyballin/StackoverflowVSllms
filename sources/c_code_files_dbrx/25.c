#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <errno.h>

int send_all(int sockfd, char *buf, size_t len) {
    ssize_t n;
    size_t total = 0;

    while (total < len) {
        if ((n = write(sockfd, buf + total, len - total)) <= 0) {
            // Handle error or terminating condition.
            // Possibly: return -1;
            perror("write");
            return -1;
        }
        total += n;
    }
    return 0;
}

int main() {
    // Example usage:
    int sockfd = 1; // Replace with an actual socket file descriptor
    char *buf = "Hello, World!";
    size_t len = strlen(buf);

    int ret = send_all(sockfd, buf, len);
    if (ret != 0) {
        printf("Error sending data\n");
    } else {
        printf("Data sent successfully\n");
    }

    return 0;
}