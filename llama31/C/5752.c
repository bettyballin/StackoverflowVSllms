#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <sys/types.h>\n#include <sys/stat.h>\n#include <fcntl.h>\n#include <unistd.h>\n#include <linux/audit.h>\n\nint main() {\n    int fd;\n    struct audit_event event;\n\n    fd = open("/dev/audit", O_RDONLY);\n    if (fd == -1) {\n        perror("open");\n        exit(EXIT_FAILURE);\n    }\n\n    while (1) {\n        ssize_t bytes_read = read(fd, &event, sizeof(event));\n        if (bytes_read != sizeof(event)) {\n            perror("read");\n            exit(EXIT_FAILURE);\n        }\n\n        if (event.type == AUDIT_SYSCALL) {\n            if (event.syscall == SYS_execve) {\n                printf("Process created: pid=%d, ppid=%d, cmdline=%s\n",\n                       event.pid, event.ppid, event.cmdline);\n            } else if (event.syscall == SYS_exit) {\n                printf("Process terminated: pid=%d\n", event.pid);\n            }\n        }\n    }\n\n    close(fd);\n    return 0;\n}