#include <stdio.h>

// Define the Particle struct
typedef struct {
    struct {
        int x;
        // Add other coordinates if necessary (e.g., y, z)
    } position;
} Particle;

// Function to perform insertion sort on particles based on their x-position
void insertionSortXPosition(Particle* particles, int length) {
    int i, j;
    Particle value;

    for (i = 1; i < length; i++) {   // Start from the second element in array
        value = particles[i];         // Assign current element as 'value'
        j = i - 1;                     // Index of previous element

        while ((j >= 0) && (particles[j].position.x > value.position.x)) {
            // Shift elements with greater key to right side in array until proper position is found for 'value'
            particles[j+1] = particles[j];   // shift current element to next index
            j = j - 1;                       // go back and repeat comparison
        }

        // Found the correct place, insert 'value' in array at this position
        particles[j + 1] = value;
    }
}

int main() {
    // Example usage:
    Particle particles[] = {
        {{5}},
        {{2}},
        {{8}},
        {{3}},
        {{1}}
    };
    int length = sizeof(particles) / sizeof(particles[0]);

    printf("Before sorting:\n");
    for (int i = 0; i < length; i++) {
        printf("Particle %d: x-position = %d\n", i, particles[i].position.x);
    }

    insertionSortXPosition(particles, length);

    printf("\nAfter sorting:\n");
    for (int i = 0; i < length; i++) {
        printf("Particle %d: x-position = %d\n", i, particles[i].position.x);
    }

    return 0;
}