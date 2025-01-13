#include <stdio.h>\n#include <stdlib.h>\n#include <sys/inotify.h>\n\nint main() {\n    int fd, wd;\n    fd = inotify_init();\n    if (fd < 0) {\n        perror("inotify_init");\n        exit(1);\n    }\n\n    wd = inotify_add_watch(fd, "/path/to/your/file.xml", IN_MODIFY);\n    if (wd < 0) {\n        perror("inotify_add_watch");\n        exit(1);\n    }\n\n    for (;;) {\n        struct inotify_event event;\n        ssize_t len = read(fd, &event, sizeof(event));\n        if (len < 0) {\n            perror("read");\n            exit(1);\n        }\n\n        if (event.mask & IN_MODIFY) {\n            printf("File modified\n");\n            // Update your GUI here\n        }\n    }\n\n    inotify_rm_watch(fd, wd);\n    close(fd);\n    return 0;\n}