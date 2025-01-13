int fd = open(PIPE_OUT, O_WRONLY);\nif (fd == -1) {\n    perror("open");\n    exit(1);\n}\n\nint flags = fcntl(fd, F_GETFL);\nif (flags == -1) {\n    perror("fcntl");\n    exit(1);\n}\n\nflags |= O_NONBLOCK;\nif (fcntl(fd, F_SETFL, flags) == -1) {\n    perror("fcntl");\n    exit(1);\n}