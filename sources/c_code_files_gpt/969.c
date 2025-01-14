#include <time.h>
#include <errno.h>

int main() {
    struct timespec req, rem;
    req.tv_sec = 30; // 30 seconds
    req.tv_nsec = 0;

    // Use CLOCK_MONOTONIC to avoid time changes affecting the sleep duration
    if (clock_nanosleep(CLOCK_MONOTONIC, 0, &req, &rem) != 0) {
        if (errno == EINTR) {
            // Sleep was interrupted by a signal
            // rem contains the remaining time
        } else {
            // Handle other errors
        }
    }

    return 0;
}