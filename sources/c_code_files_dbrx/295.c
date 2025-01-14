#include <unistd.h> // for write() and STDOUT_FILENO
#include <fcntl.h>   // for open() and O_APPEND flag
#include <stdio.h>   // for perror()
#include <stdlib.h>  // for exit()

int main() {
    int fd = open("log.txt", O_WRONLY | O_CREAT | O_APPEND, S_IRUSR | S_IWUSR);
    if (fd == -1) {
        perror("open");
        exit(EXIT_FAILURE);
    }

    dup2(fd, STDOUT_FILENO); // make stdout go to the file instead of console
    // close fd since we don't need it anymore and dup2() already duplicated it to stdout
    close(fd);

    // You can now write to stdout and it will go to the file
    printf("Hello, world!\n");

    return 0;
}