#include <sys/inotify.h>\n\nint main() {\n    int fd = inotify_init();\n    if (fd < 0) {\n        perror("inotify_init");\n        return 1;\n    }\n\n    int wd = inotify_add_watch(fd, "/path/to/directory", IN_CREATE);\n    if (wd < 0) {\n        perror("inotify_add_watch");\n        return 1;\n    }\n\n    struct inotify_event event;\n    while (read(fd, &event, sizeof(event)) > 0) {\n        if (event.mask & IN_CREATE) {\n            printf("New file created: %s\n", event.name);\n        }\n    }\n\n    inotify_rm_watch(fd, wd);\n    close(fd);\n    return 0;\n}