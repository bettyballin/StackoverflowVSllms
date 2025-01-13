#include <fcntl.h>\n#include <stdio.h>\n#include <errno.h>\n\nint main() {\n    int file = open("your_file", O_RDONLY);\n    if (file == -1) {\n        perror("open");\n        return 1;\n    }\n\n    off_t pos = lseek(file, 0, SEEK_CUR);\n    if (pos == -1) {\n        perror("lseek");\n        return 1;\n    }\n\n    printf("pos: %lli\n", pos);\n\n    // ...\n}