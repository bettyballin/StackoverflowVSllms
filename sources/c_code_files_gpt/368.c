#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <utime.h>

int main() {
    const char *path = "yourfile.txt";

    struct timeval times[2];

    // Set access time to current time
    gettimeofday(&times[0], NULL);

    // Set modification time to current time
    times[1] = times[0];

    // Update the file times
    if (utimes(path, times) != 0) {
        perror("utimes");
        return EXIT_FAILURE;
    }

    printf("File times updated successfully.\n");
    return EXIT_SUCCESS;
}