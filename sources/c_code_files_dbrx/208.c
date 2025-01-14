#include <stdio.h>
#include <stdlib.h>

int get_next(void *it_data) {
    int i = *(int *)it_data; // Convert the state/input back to an integer.
    int next = ++i;  // Producing a new value from the current iteration position (simple increment for demonstration purposes).
                     // Actual producing code will depend on specific iterator design.
    *((int*) it_data) = i + 1; // Store updated state back into struct to continue iterating in subsequent calls.
    return next;  // Return new "yield" value.
}

int main() {
    int it_data = 0; // Initialize the iterator state
    for (int i = 0; i < 10; i++) {
        printf("%d\n", get_next(&it_data)); // Call the get_next function and print the result
    }
    return 0;
}