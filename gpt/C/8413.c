#include <stdio.h>\n#include <stdlib.h>\n#include <sys/inotify.h>\n#include <unistd.h>\n#include <limits.h>\n\n#define BUF_LEN (10 * (sizeof(struct inotify_event) + NAME_MAX + 1))\n\nint main(int argc, char *argv[]) {\n    if (argc != 2) {\n        fprintf(stderr, "Usage: %s <path_to_watch>\n", argv[0]);\n        exit(EXIT_FAILURE);\n    }\n\n    int inotifyFd = inotify_init();\n    if (inotifyFd == -1) {\n        perror("inotify_init");\n        exit(EXIT_FAILURE);\n    }\n\n    int wd = inotify_add_watch(inotifyFd, argv[1], IN_MODIFY);\n    if (wd == -1) {\n        perror("inotify_add_watch");\n        exit(EXIT_FAILURE);\n    }\n\n    char buf[BUF_LEN] __attribute__ ((aligned(8)));\n    ssize_t numRead;\n    struct inotify_event *event;\n\n    printf("Watching %s for changes...\n", argv[1]);\n\n    while (1) {\n        numRead = read(inotifyFd, buf, BUF_LEN);\n        if (numRead == 0) {\n            fprintf(stderr, "Read from inotify fd returned 0!\n");\n            exit(EXIT_FAILURE);\n        }\n\n        if (numRead == -1) {\n            perror("read");\n            exit(EXIT_FAILURE);\n        }\n\n        for (char *ptr = buf; ptr < buf + numRead; ) {\n            event = (struct inotify_event *) ptr;\n\n            if (event->mask & IN_MODIFY) {\n                printf("File %s was modified.\n", argv[1]);\n                // Trigger your GUI update logic here.\n            }\n\n            ptr += sizeof(struct inotify_event) + event->len;\n        }\n    }\n\n    close(inotifyFd);\n    exit(EXIT_SUCCESS);\n}