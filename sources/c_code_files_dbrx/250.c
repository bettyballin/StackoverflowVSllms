#include <sys/mman.h>
#include <fcntl.h>
#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>

int main() {
    int fd = open("datafile", O_RDWR);
    if (fd == -1) {
        perror("open");
        exit(1);
    }

    off_t sizeOfFile = lseek(fd, 0, SEEK_END);
    if (sizeOfFile == -1) {
        perror("lseek");
        exit(1);
    }
    sizeOfFile += 42;

    void* dataPtr = mmap((void*)0, sizeOfFile, PROT_WRITE | PROT_READ, MAP_SHARED, fd, 0);
    if (dataPtr == MAP_FAILED) {
        perror("mmap");
        exit(1);
    }

    close(fd); // don't need the file descriptor any more. data is mapped into our address space.

    return 0;
}