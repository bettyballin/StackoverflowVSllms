// Using read()\n#include <unistd.h>\n#include <fcntl.h>\n#include <stdio.h>\n\nint main() {\n    int fd = open("example.txt", O_RDONLY);\n    if (fd == -1) {\n        perror("open");\n        return 1;\n    }\n\n    char buffer[128];\n    ssize_t bytesRead = read(fd, buffer, sizeof(buffer));\n    if (bytesRead == -1) {\n        perror("read");\n        return 1;\n    }\n\n    // Process buffer...\n    close(fd);\n    return 0;\n}