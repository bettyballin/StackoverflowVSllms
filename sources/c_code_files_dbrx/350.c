#include <sys/inotify.h>
#include <unistd.h>
#include <stdio.h>
#include <stdbool.h>

#define EVENT_BUF_LEN 1024 // Define the buffer length
#define EVENT_SIZE sizeof(struct inotify_event)

int main() {
    int fd = inotify_init(); // initialize an instance of an inotify handle
    if(fd == -1) {
        perror("inotify_init");
        return 1;
    };

    int wd = inotify_add_watch(fd, "/home/someFile", IN_MODIFY); // add a watch for the file
    if (wd == -1) {
        perror("inotify_add_watch");
        return 1;
    }

    while (true) {
        int length, i=0;
        char buffer[EVENT_BUF_LEN];
        length = read(fd, &buffer, EVENT_BUF_LEN);
        if (length < 0) {
            perror("read");
            return 1;
        };
        while (i < length) {
            struct inotify_event *event = (struct inotify_event *) &buffer[i];
            if (event->mask & IN_MODIFY) {
                printf("File modified!\n");
                // handle change here
            }
            i += EVENT_SIZE + event->len;
        }
    }

    inotify_rm_watch(fd, wd); // remove the watch
    close(fd); // close the inotify handle
    return 0;
}