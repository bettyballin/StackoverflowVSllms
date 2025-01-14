#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/inotify.h>
#include <unistd.h>

int main(void) {
    int fd, wd;
    char buffer[1024];

    // Open the inotify file descriptor
    fd = inotify_init();
    if (fd == -1) {
        perror("Failed to open inotify instance");
        exit(EXIT_FAILURE);
    }

    // Watches for changes on specific file and return a watch descriptor.
    wd = inotify_add_watch(fd, "path/to/log4j_output.xml", IN_MODIFY | IN_ACCESS ); // Modification or access events trigger
    if (wd == -1) {
        perror("Failed to add file watch");
        close(fd);
        exit(EXIT_FAILURE);
    }

    while (1) {
        int length = read(fd, buffer, sizeof(buffer)); // Read notifications from events into buffer
        if (length == -1 && errno != EAGAIN) {
            perror("Failed to read inotify instance");
            exit(EXIT_FAILURE);
        } else if (length > 0) {
            printf("File has been updated\n"); // Handle the event, e.g., refresh GUI
        }
    }

    close(fd);
    return 0;
}