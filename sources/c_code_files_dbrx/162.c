#include <stdio.h>
#include <sys/inotify.h>

int main() {
    int fd = inotify_init();  // Initialize the inotify system.
    if (fd == -1) {
        perror("inotify initialization");
        return 1;
    }

    int wd = inotify_add_watch(fd, "/path/to/your/file", IN_MODIFY); // Register the file to watch for changes.
    if (wd == -1) {
        perror("inotify add watch");
        return 1;
    }

    printf("Watching /path/to/your/file\n");

    while(1) { // Loop forever to keep the program running.
        char buf[4096] __attribute__ ((aligned(__alignof__(struct inotify_event))));
        const struct inotify_event *event;

        int bytes = read (fd, buf, sizeof buf);  // Wait for file change event.
        if (bytes <= 0) {
            perror ("reading from inotify fd");
            return 1;
        }

        for (size_t i=0 ; i < bytes ; i += sizeof(struct inotify_event) + event->len, event = (const struct inotify_event*)&buf[i]) {
            if (!(event->mask & IN_MODIFY))  continue; // If this file was not modified, ignore it.

            printf ("File: %s was modified.\n", event->name);
        }
    }

    return 0;
}