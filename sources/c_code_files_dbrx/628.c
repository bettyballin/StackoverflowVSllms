#include <fcntl.h> // Needed for O_RDONLY, etc.
#include <stdio.h> // For printf() and fprintf().
#include <errno.h> // To get the errno value (error number).

#define FILEPATH "/path/to/yourfile" // Replace with your file location.

int main(int argc, char *argv[]) {
    off_t current_pos;   /* The current position we will seek to. */
    unsigned long i;     /* A counter for our loop. */
    const unsigned long MAX = 100; // Adjust according to your file size.
    int fd;              /* A file descriptor, returned by open(). */

    /* Open the file. O_RDONLY means read-only access. */
    fd = open(FILEPATH, O_RDWR);

    if (fd == -1) {   // Handle if opening failed.
        perror("open");  // Print error message and exit.
        return (-1);
    } else {
        /* Seek to the end of the file */
        current_pos = lseek(fd, (off_t)0, SEEK_CUR);
        if (current_pos == -1) {  // If failed in seeking.
            perror("lseek");      // Print error message and exit.
            return (-1);
        } else {
            printf("Current position of file descriptor: %ld bytes.\n", current_pos);
            /* Close the opened file */
            close(fd);  // If not needed anymore, close it.
        } // End of else for lseek check.
    }
    return 0;
}