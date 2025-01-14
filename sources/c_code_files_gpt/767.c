#include <stdio.h>
#include <stdlib.h>
#include <sys/inotify.h>
#include <unistd.h>
#include <limits.h>

#define BUF_LEN (10 * (sizeof(struct inotify_event) + NAME_MAX + 1))

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <path_to_watch>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int inotifyFd = inotify_init();
    if (inotifyFd == -1) {
        perror("inotify_init");
        exit(EXIT_FAILURE);
    }

    int wd = inotify_add_watch(inotifyFd, argv[1], IN_MODIFY);
    if (wd == -1) {
        perror("inotify_add_watch");
        exit(EXIT_FAILURE);
    }

    char buf[BUF_LEN] __attribute__ ((aligned(8)));
    ssize_t numRead;
    struct inotify_event *event;

    printf("Watching %s for changes...\n", argv[1]);

    while (1) {
        numRead = read(inotifyFd, buf, BUF_LEN);
        if (numRead == 0) {
            fprintf(stderr, "Read from inotify fd returned 0!\n");
            exit(EXIT_FAILURE);
        }

        if (numRead == -1) {
            perror("read");
            exit(EXIT_FAILURE);
        }

        for (char *ptr = buf; ptr < buf + numRead; ) {
            event = (struct inotify_event *) ptr;

            if (event->mask & IN_MODIFY) {
                printf("File %s was modified.\n", argv[1]);
                // Trigger your GUI update logic here.
            }

            ptr += sizeof(struct inotify_event) + event->len;
        }
    }

    close(inotifyFd);
    exit(EXIT_SUCCESS);
}