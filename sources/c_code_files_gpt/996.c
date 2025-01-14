#include <stdio.h>

// Assuming 'count' and 'timestamps' are global variables
int count;
unsigned long timestamps[100]; // Assuming a size of 100 for the array

void print_timestamps(void) {
    int i;
    for (i = 0; i < count; i++) {
        printf("Timestamp %d: %lu\n", i, timestamps[i]);
    }
}

int main() {
    // Initialize 'count' and 'timestamps' before calling print_timestamps
    count = 10; // Example value
    for (int i = 0; i < count; i++) {
        timestamps[i] = i * 1000; // Example values
    }

    print_timestamps();
    return 0;
}