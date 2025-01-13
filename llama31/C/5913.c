#include <stdio.h>\n#include <unistd.h>\n\nint get_filename_from_fd(int fd, char *filename, size_t len) {\n    char path[32];\n    snprintf(path, sizeof(path), "/proc/self/fd/%d", fd);\n    ssize_t ret = readlink(path, filename, len);\n    if (ret == -1) {\n        return -1;\n    }\n    filename[ret] = '\0';\n    return 0;\n}\n\nint main() {\n    int fd = open("example.txt", O_RDONLY);\n    if (fd == -1) {\n        perror("open");\n        return 1;\n    }\n\n    char filename[256];\n    if (get_filename_from_fd(fd, filename, sizeof(filename)) == -1) {\n        perror("get_filename_from_fd");\n        return 1;\n    }\n\n    printf("Filename: %s\n", filename);\n    close(fd);\n    return 0;\n}