#include <stdio.h>

// Define the unlikely and likely macros if not already defined
#ifndef unlikely
#define unlikely(x) __builtin_expect(!!(x), 0)
#endif

#ifndef likely
#define likely(x) __builtin_expect(!!(x), 1)
#endif

int main() {
    int fd = -1; // Example value for demonstration
    int err = 0; // Example value for demonstration

    if (unlikely(fd < 0)) {
        printf("Handle error: fd is negative.\n");
    }

    if (likely(!err)) {
        printf("Continue normal execution.\n");
    }

    return 0;
}