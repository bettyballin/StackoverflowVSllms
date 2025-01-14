#include <unistd.h>
#include <stdio.h>

ssize_t read(int fd, void *buf, size_t count);

int main() {
    char buffer[1024];
    ssize_t bytes_read = read(STDIN_FILENO, buffer, 1024);
    if (bytes_read == -1) {
        perror("read");
        return 1;
    }
    printf("Read %zd bytes: %s\n", bytes_read, buffer);
    return 0;
}