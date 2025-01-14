#include <fcntl.h>
#include <sys/stat.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

int main() {
    int pipefd[2]; // Pipe Descriptor Array (Read and Write end)
    const char * myfifo = "/tmp/myfifo";
    char buf[] = "Hello, World!"; // Example buffer
    int maxsize = strlen(buf); // Example maxsize
    int len;

    if(mkfifo(myfifo, 0666) == -1){
        perror("mkfifo");
    } else {
        printf("%s created\n", "MyFIFO");
    }

    int fd = open(myfifo, O_WRONLY | O_CREAT); // Open for write only
    if(fd < 0) {
        perror("open failed");
        exit(-1);
    }

    while((len = write(fd, buf, maxsize)) == -1){
        if(errno == EAGAIN || errno == EWOULDBLOCK) sleep(1); // Backoff and retry
        else {
            perror("pipe writing failure");
            exit(-2); // Some other write error so exit!
        }
    }

    close(fd);
    return 0;
}