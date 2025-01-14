#include <stdio.h>

typedef struct {
    int x, y, z;
} Position;

typedef struct {
    Position position;
    // other particle properties
} Particle;

void insertionSort(Particle particles[], int length) {
    int i, j;
    Particle temp;

    for (i = 1; i < length; i++) {
        temp = particles[i]; // Store the entire particle struct
        j = i - 1;

        // Compare x positions
        while (j >= 0 && particles[j].position.x > temp.position.x) {
            particles[j + 1] = particles[j];
            j--;
        }
        particles[j + 1] = temp; // Insert the entire particle struct
    }
}

int main() {
    // Example usage
    Particle particles[] = {
        {{3, 0, 0}},
        {{1, 0, 0}},
        {{2, 0, 0}}
    };
    int length = sizeof(particles) / sizeof(particles[0]);

    insertionSort(particles, length);

    for (int i = 0; i < length; i++) {
        printf("Particle %d: x = %d\n", i, particles[i].position.x);
    }

    return 0;
}