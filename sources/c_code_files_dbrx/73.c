#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>

int main() {
    int fd = open("filename", O_RDWR | O_CREAT, S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH); // 0644 in octal representation
    if (fd == -1) {
        perror("open");
        exit(EXIT_FAILURE);
    }
    // You may want to add code here to handle the file descriptor
    close(fd);
    return 0;
}