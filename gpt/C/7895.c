#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <fcntl.h>\n\nint main() {\n    const char *filename = "example.txt";\n    int fd = open(filename, O_WRONLY | O_CREAT, 0644);\n    if (fd == -1) {\n        perror("open");\n        return 1;\n    }\n    \n    char buffer[1024];\n    // Fill buffer with data\n    while (/* your condition */) {\n        ssize_t written = write(fd, buffer, sizeof(buffer));\n        if (written == -1) {\n            perror("write");\n            close(fd);\n            return 1;\n        }\n    }\n\n    // Flush data to disk\n    if (fsync(fd) == -1) {\n        perror("fsync");\n        close(fd);\n        return 1;\n    }\n\n    close(fd);\n    return 0;\n}