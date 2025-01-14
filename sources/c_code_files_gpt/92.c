#include <stdio.h>
#include <sys/stat.h>
#include <unistd.h>

void check_file_type(FILE *file) {
    struct stat file_stat;
    int fd = fileno(file);

    if (fstat(fd, &file_stat) != 0) {
        perror("fstat");
        return;
    }

    if (S_ISREG(file_stat.st_mode)) {
        printf("The file is a regular file.\n");
    } else if (S_ISFIFO(file_stat.st_mode)) {
        printf("The file is a pipe (FIFO).\n");
    } else if (S_ISSOCK(file_stat.st_mode)) {
        printf("The file is a socket.\n");
    } else if (S_ISCHR(file_stat.st_mode)) {
        printf("The file is a character device.\n");
    } else if (S_ISBLK(file_stat.st_mode)) {
        printf("The file is a block device.\n");
    } else if (S_ISDIR(file_stat.st_mode)) {
        printf("The file is a directory.\n");
    } else if (S_ISLNK(file_stat.st_mode)) {
        printf("The file is a symbolic link.\n");
    } else {
        printf("The file type is unknown.\n");
    }
}

int main() {
    FILE *file = fopen("example.txt", "r");
    if (file == NULL) {
        perror("fopen");
        return 1;
    }

    check_file_type(file);

    fclose(file);
    return 0;
}