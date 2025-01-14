#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h> // for memset
#include <errno.h> // for perror

int main() {
    const char *filename = "example.txt";
    int fd = open(filename, O_WRONLY | O_CREAT, 0644);
    if (fd == -1) {
        perror("open");
        return 1;
    }
    
    char buffer[1024];
    // Fill buffer with data
    size_t bytes_written = 0;
    while (bytes_written < 1024 * 1024) { // write 1MB of data
        memset(buffer, 'a', sizeof(buffer)); // fill buffer with 'a's
        ssize_t written = write(fd, buffer, sizeof(buffer));
        if (written == -1) {
            perror("write");
            close(fd);
            return 1;
        }
        bytes_written += written;
    }

    // Flush data to disk
    if (fsync(fd) == -1) {
        perror("fsync");
        close(fd);
        return 1;
    }

    close(fd);
    return 0;
}