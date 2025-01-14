#include <stdio.h>

// Define a structure for Position
typedef struct {
    float x;
} Position;

// Define a structure for Particle
typedef struct {
    Position position;
} Particle;

// Function to sort particles based on their x-coordinate
void sortParticles(Particle particles[], int length) {
    int i, j;
    Particle value;

    for (i = 1; i < length; i++) {
        value = particles[i]; // store particles[i] rather than its x coordinate
        j = i - 1;
        while (j >= 0 && particles[j].position.x > value.position.x) { // changed
            particles[j + 1] = particles[j];
            j = j - 1;
        }
        particles[j + 1] = value; // copy from temporary
    }
}

int main() {
    // Example usage
    Particle particles[] = {
        {{5.0}}, // Assuming particles with x coordinates 5.0, 2.0, 8.0, 1.0, 9.0
        {{2.0}},
        {{8.0}},
        {{1.0}},
        {{9.0}}
    };
    int length = sizeof(particles) / sizeof(particles[0]);

    printf("Before sorting:\n");
    for (int i = 0; i < length; i++) {
        printf("Particle %d: x = %f\n", i + 1, particles[i].position.x);
    }

    sortParticles(particles, length);

    printf("\nAfter sorting:\n");
    for (int i = 0; i < length; i++) {
        printf("Particle %d: x = %f\n", i + 1, particles[i].position.x);
    }

    return 0;
}