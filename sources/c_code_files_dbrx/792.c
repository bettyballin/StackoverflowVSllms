#include <fcntl.h>
#include <sys/stat.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    const char* path = "/path/to/your_file";

    struct timespec touchTime[2];
    time_t t = time(NULL);
    touchTime[0] = (struct timespec){ .tv_sec = t, .tv_nsec = 0 }; // Modification timestamp
    touchTime[1] = (struct timespec){ .tv_sec = t, .tv_nsec = 0 }; // Access timestamp

    if (utimensat(AT_FDCWD, path, touchTime, 0) == -1) {
        perror("Error modifying file timestamps");
        exit(EXIT_FAILURE);
    } else {
        printf("Timestamps of %s updated.\n", path);
        return EXIT_SUCCESS;
    }
}