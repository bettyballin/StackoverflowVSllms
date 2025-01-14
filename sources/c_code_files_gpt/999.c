#include <stdio.h>

int count = 5;  // assuming count is defined somewhere
unsigned long timestamps[] = {1, 2, 3, 4, 5};  // assuming timestamps is defined somewhere

static int print_timestamps_init(void) {
    int i;
    for (i = 0; i < count; i++) {
        printf("Timestamp %d: %lu\n", i, timestamps[i]);
    }
    return 0;
}

int main() {
    print_timestamps_init();
    return 0;
}