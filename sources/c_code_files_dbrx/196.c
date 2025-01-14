#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to swap two integers
void swap(int* a, int* b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main() {
    srand(time(NULL)); // Initialize random number generator
    int used[52] = {0}; // Assuming initially all cards are not used
    int indices[52];
    int totalCards = 52;
    int numUsed = 0;

    for (int k = 0; k < 52; ++k) {
        if (used[k]) {
            numUsed += 1;
        } else {
            indices[totalCards - 1] = k; // Corrected index calculation
            totalCards -= 1; // Decrease the number of remaining non-used cards to consider for shuffle
        }
    }

    // Shuffling only the non-used portion of array using Fisher-Yates algorithm
    for (int i = totalCards; i > 0; --i) {
        swap(&indices[i], &indices[(rand() % (i + 1))]);
    }

    // Example: Print the shuffled indices
    for (int i = 0; i < 52 - numUsed; ++i) {
        printf("%d ", indices[i]);
    }
    printf("\n");

    return 0;
}