#include <stdio.h>\n#include <stdlib.h>\n#include <fcntl.h>\n#include <unistd.h>\n\n#define SECTOR_SIZE 512\n\nint main() {\n    int fd;\n    char buffer[SECTOR_SIZE];\n\n    // Open the disk device, replace '/dev/disk0' with your actual boot disk\n    fd = open("/dev/rdisk0", O_RDONLY);\n    if (fd < 0) {\n        perror("Failed to open device");\n        exit(EXIT_FAILURE);\n    }\n\n    // Move file pointer to sector 2 (512 bytes)\n    if (lseek(fd, SECTOR_SIZE * 2, SEEK_SET) != SECTOR_SIZE * 2) {\n        perror("lseek failed");\n        close(fd);\n        exit(EXIT_FAILURE);\n    }\n\n    // Read the sector\n    ssize_t bytesRead = read(fd, buffer, SECTOR_SIZE);\n    if (bytesRead < SECTOR_SIZE) {\n        perror("read failed");\n        close(fd);\n        exit(EXIT_FAILURE);\n    }\n\n    printf("Read %zd bytes from sector 2:\n", bytesRead);\n\n    // Optionally process the buffer here\n    for (size_t i = 0; i < bytesRead; ++i) {\n        printf("%02x ", buffer[i]);\n        if ((i + 1) % 16 == 0) printf("\n");\n    }\n    printf("\n");\n\n    close(fd);\n    return 0;\n}