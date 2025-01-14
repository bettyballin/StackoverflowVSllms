#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <errno.h>
#include <unistd.h>

int main() {
    int fd; // assuming fd is a file descriptor, you need to open a file to get one
    fd = open("example.txt", O_RDWR); // replace "example.txt" with your file name
    if (fd == -1) {
        printf("Failed to open file\n");
        exit(-1);
    }

    struct flock lock;
    lock.l_type = F_WRLCK;    /* or F_RDLCK for read-only */
    lock.l_whence = SEEK_SET; /* from beginning of file*/
    lock.l_start = 0;         /* or offset of write region*/
    lock.l_len = 0;           /* length to be locked, 0 means lock until EOF*/
    if (fcntl(fd, F_SETLKW, &lock) != 0) {
        printf("Failed to acquire lock\n");
    } else {
        // Read/Write the file here
        if (fcntl(fd, F_UNLCK, &lock) != 0){ /* always unlock after use */
           printf("Unable to release lock. Exiting. Error: %d\n", errno);
           exit(-1);   // or equivalent error handling for daemons
        }
    }
    close(fd); // don't forget to close the file
    return 0;
}