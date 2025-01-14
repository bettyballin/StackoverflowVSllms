#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Assuming these are defined somewhere in your original code
// For this example, let's define them here.
#define MAX_INDICES 100
int indices[MAX_INDICES];
int numUnused = MAX_INDICES;

int getRandomIndex() {
    // Seed the random number generator if you haven't already
    static int seeded = 0;
    if (!seeded) {
        srand(time(NULL));
        seeded = 1;
    }

    int idx = rand() % numUnused; // Generate index in range [0..numUnused)
    return indices[idx];          // Get the corresponding original index from array
}

int main() {
    // Example initialization for indices
    for (int i = 0; i < MAX_INDICES; i++) {
        indices[i] = i; // Example values
    }

    printf("Random index: %d\n", getRandomIndex());

    return 0;
}