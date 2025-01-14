#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>
#include <string.h> // added for strlen function

int main() {
    int fd;

    // Use O_WRONLY for write-only access, O_CREAT to create the file if it doesn't exist,
    // and O_TRUNC to truncate the file to zero length if it already exists.
    // S_IRUSR | S_IWUSR gives read and write permissions to the owner.
    fd = open("output.txt", O_WRONLY | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR);

    if (fd == -1) {
        // Handle error
        return 1;
    }

    // Write to the file
    const char *text = "Hello, World!\n"; // changed to \n for proper newline character
    write(fd, text, strlen(text));

    // Close the file
    close(fd);

    return 0;
}