#include <stdio.h>

// Define the constant for the king safety penalty
#define KING_SAFETY_PENALTY 100

// Define a function to check if the king is exposed
// For this example, we'll just return 1 (true) or 0 (false)
int isKingExposed(int kingPosition) {
    // This is a placeholder function and should be replaced with actual logic
    return 1; // For demonstration purposes, assume the king is exposed
}

int main() {
    int score = 0; // Initialize the score
    int kingPosition = 0; // Initialize the king's position

    // Check if the king is exposed and adjust the score accordingly
    if (isKingExposed(kingPosition)) {
        score -= KING_SAFETY_PENALTY;
    }

    // Print the final score
    printf("Final score: %d\n", score);

    return 0;
}