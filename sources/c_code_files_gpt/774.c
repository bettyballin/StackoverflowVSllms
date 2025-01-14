#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/inotify.h>
#include <limits.h>

#define BUF_LEN (10 * (sizeof(struct inotify_event) + NAME_MAX + 1))

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <file-path>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int inotify_fd = inotify_init();
    if (inotify_fd == -1) {
        perror("inotify_init");
        exit(EXIT_FAILURE);
    }

    int wd = inotify_add_watch(inotify_fd, argv[1], IN_MODIFY);
    if (wd == -1) {
        perror("inotify_add_watch");
        close(inotify_fd);
        exit(EXIT_FAILURE);
    }

    printf("Watching %s for changes.\n", argv[1]);

    char buf[BUF_LEN];
    while (1) {
        ssize_t num_read = read(inotify_fd, buf, BUF_LEN);
        if (num_read == 0) {
            fprintf(stderr, "read() from inotify fd returned 0!\n");
            exit(EXIT_FAILURE);
        }

        if (num_read == -1) {
            perror("read");
            exit(EXIT_FAILURE);
        }

        for (char *ptr = buf; ptr < buf + num_read; ) {
            struct inotify_event *event = (struct inotify_event *) ptr;
            if (event->mask & IN_MODIFY) {
                printf("File %s modified.\n", argv[1]);
            }
            ptr += sizeof(struct inotify_event) + event->len;
        }
    }

    // This line is never reached due to the infinite loop above
    // close(inotify_fd);
    return 0;
}