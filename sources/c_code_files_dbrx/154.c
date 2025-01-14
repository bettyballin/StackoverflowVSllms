#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/stat.h>

void check_file_type(FILE* fp) {
    int fd = fileno(fp); // Get the file descriptor from FILE pointer
    struct stat sb;
    if (fstat(fd, &sb) == -1) {
        perror("fstat");
        return;
    }

    switch (sb.st_mode & S_IFMT) {
        case S_IFIFO: 
            printf("This is a pipe\n"); 
            break;
        case S_IFREG: 
            printf("This is a regular file\n"); 
            break;
        // Similarly, you can add cases for sockets, directories etc.
        default:
            printf("This is an unknown file type\n"); 
            break;
    }
}

int main() {
    FILE* fp = fopen("test.txt", "r");
    if (fp == NULL) {
        perror("fopen");
        return 1;
    }

    check_file_type(fp);
    fclose(fp);
    return 0;
}