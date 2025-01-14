#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/stat.h>
#include <sys/types.h>

int main() {
    const char *path = "yourfile.txt";

    struct timespec times[2];

    // Set access time to current time
    clock_gettime(CLOCK_REALTIME, &times[0]);

    // Set modification time to current time
    times[1] = times[0];

    // Update the file times
    if (utimensat(AT_FDCWD, path, times, 0) != 0) {
        perror("utimensat");
        return EXIT_FAILURE;
    }

    printf("File times updated successfully.\n");
    return EXIT_SUCCESS;
}