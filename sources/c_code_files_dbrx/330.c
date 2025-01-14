#include <stdio.h>
#include <unistd.h>
#include <time.h>

int main(void) {
    int i;

    for (i = 1; i <= 10; ++i) {
        printf("%3d ", i);
        fflush(stdout); /* Force output */
        usleep(500 * 1000); /* Sleep half a second */
    }
    putchar('\r'); /* Move cursor to start of line */
    return puts("Ready") && 0; /* Print message and return success */
}