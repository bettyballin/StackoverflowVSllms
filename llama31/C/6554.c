#include <stdio.h>\n#include <stdlib.h>\n#include <unistd.h>\n#include <fcntl.h>\n#include <sys/stat.h>\n\n#define FIFO_NAME "/tmp/myfifo"\n\nint main() {\n    int fd;\n    char buffer[1024];\n\n    // Open the FIFO for reading\n    fd = open(FIFO_NAME, O_RDONLY);\n    if (fd == -1) {\n        perror("open");\n        exit(1);\n    }\n\n    // Read from the FIFO\n    while (read(fd, buffer, 1024) > 0) {\n        printf("%s", buffer);\n    }\n\n    // Close the FIFO\n    close(fd);\n\n    return 0;\n}