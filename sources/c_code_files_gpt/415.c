#include <stdio.h>
#include <stdlib.h>
#include <sys/inotify.h>
#include <unistd.h>

int main() {
    int fd = inotify_init();
    if (fd < 0) {
        perror("inotify_init");
        exit(EXIT_FAILURE);
    }

    int wd = inotify_add_watch(fd, "/path/to/your/directory", IN_CREATE);
    if (wd == -1) {
        perror("inotify_add_watch");
        exit(EXIT_FAILURE);
    }

    char buffer[1024];
    while (1) {
        int length = read(fd, buffer, sizeof(buffer));
        if (length < 0) {
            perror("read");
            exit(EXIT_FAILURE);
        }

        if (length == 0) {
            break;
        }

        struct inotify_event *event;
        for (char *ptr = buffer; ptr < buffer + length; ) {
            event = (struct inotify_event *) ptr;
            if (event->mask & IN_CREATE) {
                printf("New file created: %s\n", event->name);
            }
            ptr += sizeof(struct inotify_event) + event->len;
        }
    }

    inotify_rm_watch(fd, wd);
    close(fd);
    return 0;
}