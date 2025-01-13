#include <stdio.h>\n#include <stdlib.h>\n#include <sys/mman.h>\n#include <fcntl.h>\n#include <unistd.h>\n\n#define FILEPATH "/tmp/shared_memory.tmp"\n#define SIZE     4096\n\nint main() {\n    int fd;\n    pid_t child_pid;\n\n    // Create a file to use for the shared memory\n    if ((fd = open(FILEPATH, O_RDWR | O_CREAT | O_TRUNC, (mode_t)0600)) == -1) {\n        perror("Error opening file for writing");\n        exit(EXIT_FAILURE);\n    }\n\n    // Stretch the file size to the size of the (mmapped) array\n    if (lseek(fd, SIZE-1, SEEK_SET) == -1) {\n        close(fd);\n        perror("Error calling lseek() to 'stretch' the file");\n        exit(EXIT_FAILURE);\n    }\n\n    /* Something needs to be written at the end of the stretched file so\n       the file has a size and space on disk. Just one byte will do.\n       So writing a dot at the last byte suffices. */\n    if (write(fd, "", 1) != 1) {\n        close(fd);\n        perror("Error writing last byte of the file");\n        exit(EXIT_FAILURE);\n    }\n\n    // Map the file into this process\n    char *map = mmap(0, SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);\n    if (map == MAP_FAILED) {\n        close(fd);\n        perror("Error mmapping the file");\n        exit(EXIT_FAILURE);\n    }\n\n    const char *message = "Hello from parent process";\n    // Write a message to shared memory region\n    sprintf(map, "%s", message);\n\n    child_pid = fork();\n    if (child_pid == 0) {\n        printf("Child process: %s\n", map);\n    } else {\n        wait(NULL); // Wait for the child to finish\n        printf("Parent process completed.\n");\n    }\n\n    // Remove mapping and close file descriptor\n    munmap(map, SIZE);\n    close(fd);\n\n    return 0;\n}